<#macro exe>
package com.galebo.lowyer.dao;

import com.galebo.lowyer.dao.ibatis.GenericDaoiBatis;
<#list importBeans as one>
import com.galebo.lowyer.model.${one};
</#list>
public class CommonDao {
<#list beans as one>
    GenericDaoiBatis<${one},Long> ${one}Dao=new GenericDaoiBatis<${one},Long>(${one}.class);
</#list>
        <#list beans as one>
    public GenericDaoiBatis<${one}, Long> get${one}Dao() {
		return ${one}Dao;
	}
		</#list>
}
</#macro>
<@exe/>
