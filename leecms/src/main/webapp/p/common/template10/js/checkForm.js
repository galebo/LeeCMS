function zCheckSearch(the_form){
  if(the_form.key.value==""){
      alert("搜索关键词不能为空！");
      the_form.key.focus();
      return false;
  }
    return true;
}