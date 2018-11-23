$(document).ready(function () {
    $("#btn-save").on("click", function () {
        saveClient();
    });
});

function saveClient() {
    var name = $("#input-client-name").val();
    var cpf = $("#input-client-cpf").val();
    var ddd = $("#input-client-ddd").val();
    var telephone = $("#input-client-telephone").val();
    var vehiclePlate = $("#input-vehicle-plate").val();
    var vehicleModel = $("#select-vehicle-model").val();
    var vehicleColor = $("#select-vehicle-color").val();

    newClient(name, cpf, ddd, telephone, vehiclePlate, vehicleModel, vehicleColor);
}

function newClient(name, cpf, ddd, telephone, plate, model, color) {

    var client = {
        "name" : name,
        "cpf" : cpf,
        "telephone" : ddd+telephone,
        "vehicleList" : []
    };

    $.ajax({
        'type': 'POST',
        'url': "http://localhost:8080/api/client/new",
        'contentType': 'application/json',
        'data': JSON.stringify(client)
    }).done(function (idClient) {

        var vehicle = {
            "placa" : plate,
            "model" : model,
            "color" : color,
            "client" : { "idClient" : idClient}
        };

        $.ajax({
            'type': 'POST',
            'url': "http://localhost:8080/api/vehicle/new",
            'contentType': 'application/json',
            'data': JSON.stringify(vehicle)
        }).done(function (response) {
            console.log("idClient: ");
            console.log(idClient);
            console.log("response: ");
            console.log(response);
        });
    });


}
