$().ready(function(){
  // Instant Search
  $('#search_input').keyup(function(){
    $('.search_item').each(function(){
      var re = new RegExp($('#search_input').val(), 'i')
      if($(this).children('.search_text')[0].innerHTML.match(re)){
        $(this).show();
      }else{
        $(this).hide();
      };
    });
  });
});
