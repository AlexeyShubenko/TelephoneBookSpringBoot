/**
 * Created by Alexey on 09.08.2017.
 */
function fillTable(table, i, contact) {
    console.log(contact.contactId);
    var newRow=table.insertRow(i+1);
    newRow.className="forTd";
    var newCell = newRow.insertCell(0);
    newCell.innerHTML=contact.lastName;
    var newCell = newRow.insertCell(1);
    newCell.innerHTML=contact.firstName;
    var newCell = newRow.insertCell(2);
    newCell.innerHTML=contact.middleName;
    var newCell = newRow.insertCell(3);
    newCell.innerHTML=contact.mobPhoneNumber;
    var newCell = newRow.insertCell(4);
    newCell.innerHTML=contact.homePhoneNumber;
    var newCell = newRow.insertCell(5);
    newCell.innerHTML=contact.address;
    var newCell = newRow.insertCell(6);
    newCell.innerHTML=contact.email;
    var newCell = newRow.insertCell(7);
    newCell.id = "noneBorder";
    newCell.innerHTML="<a class='button' href='./deleteContact/"+ contact.contactId + "'>" + "delete" + "</a>";
    var newCell = newRow.insertCell(8);
    newCell.id = "noneBorder";
    newCell.innerHTML="<a class='button' href=" + contact.contactId + ">" + "update" + "</a>";
    // console.log("<a class='button' href='./deleteContact/"+contact.contactId + "'>" + "delete" + "</a>");
}
