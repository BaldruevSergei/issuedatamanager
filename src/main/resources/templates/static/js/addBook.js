$(document).ready(function () {
    $('#addBookForm').on('submit', function (e) {
        e.preventDefault(); // Останавливаем стандартное поведение формы

        const formData = {
            isbn: $('#isbn').val(),
            title: $('#title').val(),
            author: $('#author').val(),
            genres: $('#genres').val()
        };

        $.ajax({
            url: '/rest/library/addBook', // Путь к  REST-контроллеру
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(formData),
            success: function (response) {
                $('#responseMessage').text(response.message).css('color', 'green');
            },
            error: function (xhr) {
                const errorResponse = JSON.parse(xhr.responseText);
                $('#responseMessage').text(errorResponse.message).css('color', 'red');
            }
        });
    });
});
