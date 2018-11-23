
function searchClient() {
    var selectInput = $("#select-document");
    var valueOf = $("#value-of").val();

    if ( selectInput.val() === 'document') {
        searchByCpf(valueOf)
    } else {
        searchByName(valueOf)
    }
}

function searchByCpf(cpf) {
    clearTable();
    $.get("http://localhost:8080/api/client/find-by-document",{ "cpf" : cpf}, function (data) {
        fillTable(data)
    });
}

function searchByName(name) {
    clearTable();
    $.get("http://localhost:8080/api/client/find-by-name",{ "name" : name}, function (data) {
        fillTable(data)
    });
}

function clientPageInit() {
    clearTable();
    $.get("http://localhost:8080/api/client/find-all", function (data) {
        fillTable(data);
    });
    var selectValue = $("#select-document").val();
    $("#btn-form").on("click", searchClient(selectValue));
}

function clearTable() {
    $("tbody tr").remove();
}

function fillTable(data) {
    for (var i = 0; i < data.length; i++) {
        var name = data[i].name;
        var cpf = data[i].cpf;
        var telephone = data[i].telephone;

        var tableBody = $("#client-table").find("tbody");
        var newLine = enterNewLine(name, cpf, telephone);
        tableBody.append(newLine);
    }
}

function enterNewLine(name, cpf, telephone) {
    var line = $("<tr>");
    var nameColumn = $("<td>").text(name);
    var cpfColumn = $("<td>").text(cpf);
    var telephoneColumn = $("<td>").text(telephone);

    line.append(nameColumn);
    line.append(cpfColumn);
    line.append(telephoneColumn);

    return line;
}
