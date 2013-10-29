<#import "${ftlBasePath}/common.ftl" as g/>
<#import "${ftlPath}/common/frame.ftl" as frame/>
<#import "${ftlPath}/common/self.ftl" as self/>
<#import "${ftlPath}/common/area.ftl" as area/>

<@frame.exe1 bean=data>
<@area.index_area1 item1=data.item1 item2=data.item2 loop=common.groupLoops['loop1']/>
<@area.index_statusDiv item=data.item1/>
<@area.index_area2 item1=data.item3 item2=data.item4 item3=data.item5/>
<@area.index_area4 item1=data.item6 item2=data.item7 item3=data.item8/>
<@area.index_area3 item1=data.item1 item2=data.item1 item3=data.item1/>
<@area.index_area4 item1=data.item3 item2=data.item5 item3=data.item1/>
<@area.index_area4 item1=data.item6 item2=data.item2 item3=data.item1/>
</@frame.exe1>


