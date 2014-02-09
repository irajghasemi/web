(function($) {
    $.fn.DatePickerControl = function(options) {

        var defaults = {
            divPopupClass: "data_picker_popup",
            datePickerLinkCss: "link_down_arrow",
            datePickerContainerCss: "data_picker_container",
            datePresetText: "Preset:",
            datePickerThreeMonthText: "3 months",
            datePickerSixMonthText: "6 months",
            datePickerYearText: "1 Year",
            datePickerFromToDateValidation: true,
            datePickerValidationMessage: "Selected date range is invalid",
            datePickerValidationMessageCss: "font_red",
            dateHiddenFieldId: ''
        };

        var options = $.extend(defaults, options);

        alert(options.datePickerFromToDateValidation);
        /* Generate the HTML for the current state of the date picker. */
        function generateHTML() {
            var html = "";
            html = html + " <a href='javascript:void(0);' class='" +
             options.datePickerLinkCss + "'>Click on link</a> ";
            html = html + " <div class='" + options.datePickerContainerCss + "' >";

            var durationlinks = "";
            durationlinks = " <a class='3monthlink' href='javascript:void(0);'>"
                  + options.datePickerThreeMonthText + "</a>  | ";
            durationlinks = durationlinks + " <a class='6monthlink' href='javascript:void(0);'>"
                    + options.datePickerSixMonthText + "</a> | ";
            durationlinks = durationlinks + " <a class='1yearlink' href='javascript:void(0);'>" + options.datePickerYearText + "</a> ";
            html = html + "<p> " + options.datePresetText + durationlinks + "</p>";
            if (options.datePickerFromToDateValidation)
                html = html + "<p class=" + options.datePickerValidationMessageCss + ">" + options.datePickerValidationMessage + "</p>";
            html = html + "<div class='float_left'><div class='fromdatepicker' class='font_11'></div></div>";
            html = html + "<div class='float_right'><div class='todatepicker' class='font_11'></div></div>";
            html = html + "<p> <p><div style='clear:both' class='float_right'>"
                + "<label><input type='button' value='Done'  class='button' /></label<div>";
            html = html + "<div class='clear'></div></div> ";

            return html;
        }

        return this.each(function() {
            obj = $(this);
            obj.append(generateHTML());
            var validatonMessage = $("." + options.datePickerValidationMessageCss, obj);
            validatonMessage.hide();
            var fromDatePickerContainer = $("." + options.datePickerContainerCss, obj);
            fromDatePickerContainer.hide();
            var fromDatePicker = $(".fromdatepicker", obj);
            var toDatePicker = $(".todatepicker", obj);
            fromDatePicker.datepicker();
            toDatePicker.datepicker();
            var threeMonthLink = $(".3monthlink", obj);
            var sixMonthLink = $(".6monthlink", obj);
            var yearLink = $(".1yearlink", obj);
            threeMonthLink.click(function() {
                var toDate = toDatePicker.datepicker("getDate");
                var fromDate = toDate.add(-3, "months", false);
                fromDatePicker.datepicker("setDate", fromDate);
                validatonMessage.hide("fast");
            });
            sixMonthLink.click(function() {
                var toDate = toDatePicker.datepicker("getDate");
                var fromDate = toDate.add(-6, "months", false);
                fromDatePicker.datepicker("setDate", fromDate);
                validatonMessage.hide("fast");
            });
            yearLink.click(function() {
                var toDate = toDatePicker.datepicker("getDate");
                var fromDate = toDate.add(-12, "months", false);
                fromDatePicker.datepicker("setDate", fromDate);
                validatonMessage.hide("fast");
            });

            var datePickerLink = $("." + options.datePickerLinkCss, obj);
            //Set the default date
          
            var hdndateRange = $("#" + options.dateHiddenFieldId);

            if (hdndateRange) {

                var dateRange = hdndateRange.val().split("|");
                if (dateRange.length == 2) {
                    fromDatePicker.datepicker("setDate", dateRange[0]);
                    toDatePicker.datepicker("setDate", dateRange[1]);
                    datePickerLink.html(fromDatePicker.datepicker("getDate").dateFormat("medium") + " - "
                            + toDatePicker.datepicker("getDate").dateFormat("medium"));
                }
            }

            datePickerLink.click(function() {
                fromDatePickerContainer.show("fast");
            });

            var doneButton = $(".button", obj);
            doneButton.click(function() {
                var toDate = toDatePicker.datepicker("getDate");
                var fromDate = fromDatePicker.datepicker("getDate");                 
                if (options.datePickerFromToDateValidation) {
                    if (fromDate <= toDate) {
                        hdndateRange.val(fromDate.dateFormat("medium") + "|" + toDate.dateFormat("medium"));                       
                        datePickerLink.html(fromDate.dateFormat("medium") + " - " + toDate.dateFormat("medium"));
                        validatonMessage.hide("100", function() { fromDatePickerContainer.hide("slow"); });
                    }
                    else {
                        validatonMessage.show("slow");
                        // validatonMessage.hide("slow")
                    }
                }
                else {
                    //  hdndateRange.value = fromDate.dateFormat("medium") + "|" + toDate.dateFormat("medium");
                    // alert("ok");
                    hdndateRange.val(fromDate.dateFormat("medium") + "|" + toDate.dateFormat("medium"));
                    alert(hdndateRange.val());
                    fromDatePickerContainer.hide("slow", function() { datePickerLink.html(fromDate.dateFormat("medium") + " - "
                                                + toDate.dateFormat("medium")); });
                }
            });
            this.GetFromDate = function() {
                var fromDate = fromDatePicker.datepicker("getDate");
                return fromDate;
            }
            this.GetToDate = function() {
                var toDate = toDatePicker.datepicker("getDate");
                return toDate;
            }
        });
    };
})(jQuery);