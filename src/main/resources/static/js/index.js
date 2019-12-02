var apiList = new Vue({
    el: '#api-list',
    data: {
        apis: []
    },
    mounted: function () {
        console.log("done");
        $.ajax({
            url: 'api/',
            type: "get",
            success: function (result) {
                apiList.apis = JSON.parse(result);
            },
            error: function () {
                alert("An error during data retrieving. Please, try again later");
            }
        });
    }
});
