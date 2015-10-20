(function ($) {
    $._dialogFunc__ = {};

    function openDialog(isConfirm, title, content, confirmCallback, closeCallback) {
        $._dialogFunc__.confirm = function () {
            if (confirmCallback) confirmCallback();
            $html.confirm = true;
            $html.modal('hide');
        };
        title = title || "";

        var id = 'myModal' + Math.random().toString().replace('.', '_');
        var html = '<div class="modal hide fade" id="' + id + '">'
            + '<div class="modal-header">'
            + '<button type="button" class="close" data-dismiss="modal">×</button>'
            + '<h3>' + title + '</h3>'
            + '</div>'
            + '<div class="modal-body">'
            + '<p>' + content + '</p>'
            + '</div>'
            + '<div class="modal-footer">'
            + '<a href="javascript:void(0);" class="btn" data-dismiss="modal">' + (isConfirm ? '取消' : '确定') + '</a>'
            + ( isConfirm ? '<a href="javascript:void(0);" class="btn btn-primary" onclick="$._dialogFunc__.confirm()">确认</a>' : '')
            + '</div>'
            + '</div>';
        var $html = $(html);
        $html.modal().on('hidden.bs.modal', function () {
            if (!$html.confirm) {
                if (closeCallback) closeCallback();
            }
            $html.remove();
        });
    }

    $.alert = function (text, closeCallBack) {
        openDialog(false, "", text, null, closeCallBack);
    };

    $.confirm = function (text, confirmCallback, closeCallback) {
        openDialog(true, "", text, confirmCallback, closeCallback);
    };

})(jQuery);