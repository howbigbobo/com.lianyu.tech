;
(function ($) {
    function getValueFromOption(option, name, defaultValue) {
        if (typeof(option[name]) === "undefined") return;
        if (typeof(option[name]) === "function") {
            return option[name](defaultValue);
        } else {
            return option[name];
        }
    }

    function getFormData(ctrl, option) {
        var $ctrl = $(ctrl);
        if (ctrl.length == 0) return {};
        option = option || {};
        var inputs = $ctrl.find('input[name]');
        var selects = $ctrl.find('select[name]');

        var data = {};
        $.each(inputs, function (i, e) {
            var ele = $(e);
            var name = ele.attr('name');
            data[name] = $.trim(ele.val());
            if (option[name]) {
                data[name] = getValueFromOption(option, name, option[name]);
            }
        });

        return data;
    }

    function setFormData(ctrl, data, option) {
        var $ctrl = $(ctrl);
        if (ctrl.length == 0) return;
        option = option || {};
    }

    $.fn.formData = function () {
        return getFormData(this);
    }
})(jQuery);