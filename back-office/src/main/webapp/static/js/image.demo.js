$(function () {
    $('#image-pic').fileupload({
        dataType: 'json',
        add: function (e, data) {
            data.context = $('<button/>').text('Upload')
                .appendTo($('#image-container'))
                .click(function () {
                    data.context = $('<p/>').text('Uploading...').replaceAll($(this));
                    data.submit();
                });
        },
        progressall: function (e, data) {
            console.log(1);
            var progress = parseInt(data.loaded / data.total * 100, 10);
            $('.bar').css('width', progress + '%');
        },
        done: function (e, data) {
            data.context.text('Upload finished.');
            $.each(data.result.files, function (index, file) {
                $('<p/>').text(file.name).appendTo($('#image-container'));
            });
        }
    });
});