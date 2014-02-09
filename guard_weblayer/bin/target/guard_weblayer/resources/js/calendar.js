$(function() {
    var dates = $( "#from, #to" ).datepicker({
        defaultDate: "+1w",
        numberOfMonths: 2,
        beforeShow: function( ) {
            var other = this.id == "from" ? "#to" : "#from";
            var option = this.id == "from" ? "maxDate" : "minDate";
            var selectedDate = $(other).datepicker('getDate');
            
            $(this).datepicker( "option", option, selectedDate );
        }
    }).change(function(){
        var other = this.id == "from" ? "#to" : "#from";
        
        if ( $('#from').datepicker('getDate') > $('#to').datepicker('getDate') )
            $(other).datepicker('setDate', $(this).datepicker('getDate') );
    });
    
    
});

