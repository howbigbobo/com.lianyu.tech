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
        var inputs = $ctrl.find('input[name],select[name]');

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

    function setFormData(ctrl, data, option, force) {
        var $ctrl = $(ctrl);
        if (ctrl.length == 0) return;
        option = option || {};
    }

    $.fn.formData = function (data, force) {
        if (data) {
            setFormData(data, force);
        }
        else {
            return getFormData(this);
        }
    }
})(jQuery);
