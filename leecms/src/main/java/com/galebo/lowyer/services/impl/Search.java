package com.galebo.lowyer.services.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Hit;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.store.LockObtainFailedException;
import org.springframework.stereotype.Service;

import com.galebo.common.UtilsCommon;
import com.galebo.common.WorkerException;
import com.galebo.lowyer.Constants;
import com.galebo.lowyer.bean.common.UrlNameAuthorHtml;
import com.galebo.lowyer.model.ColColumnContent;

@Service("Search")
public class Search extends BaseService{
    protected final Log log = LogFactory.getLog(getClass());
	private static final String spliter = "lyz";
	private static final String path = "url";
	private static final String body = "body";

	public void build(String indexPath,Long userId,Url url) throws CorruptIndexException, LockObtainFailedException, IOException {
		long startTime = new Date().getTime();
		List<ColColumnContent> columnContents = queryDao.getColumnContents(userId);
		System.out.println("共" + columnContents.size() + "文件正在被索引....");
		IndexWriter indexWriter = new IndexWriter(indexPath+Constants.FILE_SEP+userId, new StandardAnalyzer(), true, IndexWriter.MaxFieldLength.UNLIMITED);
		// 增加document到索引去
		for (ColColumnContent colColumnContent : columnContents) {
			//System.out.println(temp);
			String url_name=url.getDetailUrl(colColumnContent.getColumnContentId())
			+spliter+colColumnContent.getConContent().getNameCn()
			+spliter+UtilsCommon.sdf.format(colColumnContent.getConContent().getUpdateTime());
			Field FieldPath = new Field(path,url_name,Field.Store.YES, Field.Index.NO);
			Field FieldBody = new Field(body, colColumnContent.getConContent().getHtml(), Field.Store.YES, Field.Index.ANALYZED, Field.TermVector.WITH_POSITIONS_OFFSETS);
			Document document = new Document();
			document.add(FieldPath);
			document.add(FieldBody);
			indexWriter.addDocument(document);
		}
		// optimize()方法是对索引进行优化
		indexWriter.optimize();
		indexWriter.close();

		// 测试一下索引的时间
		long endTime = new Date().getTime();
		log.info("这花费了" + (endTime - startTime) + " 毫秒来把文档增加到索引里面去!" + indexPath);
	}

	public List<UrlNameAuthorHtml> search2(String indexPath,Long userId,String queryKey) throws CorruptIndexException, IOException, ParseException {
		IndexSearcher searcher = new IndexSearcher(indexPath+Constants.FILE_SEP+userId);
		QueryParser queryParser = new QueryParser(body, new StandardAnalyzer());
		Query query = queryParser.parse(queryKey);
		Hits hits = searcher.search(query);
		List<UrlNameAuthorHtml> lists=new  ArrayList<UrlNameAuthorHtml>();
		log.info("查找\""+queryKey+"\" 共" +hits.length() + "个结果");
		for (Iterator iterator2 = hits.iterator(); iterator2.hasNext();) {
			Hit type = (Hit) iterator2.next();
			UrlNameAuthorHtml o=new UrlNameAuthorHtml();
			String url_name = type.getDocument().getField(path).stringValue();
			String[] split = url_name.split(spliter);
			o.setName(split[1]);
			o.setUrl(split[0]);
			try {
				o.setUpdateTime(UtilsCommon.sdf.parse(split[2]));
			} catch (java.text.ParseException e) {
				WorkerException.handleNoThrowNew(e);
				o.setUpdateTime(new Date());
			}
			lists.add(o);
		}
		return lists;
	}
}
