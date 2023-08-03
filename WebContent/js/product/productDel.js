
const checks = document.getElementsByClassName('check');
const delbtn = document.getElementById('delbtn');
const checkallbtn = document.getElementById('checkall');
let checkedBox = [];

delbtn.addEventListener('click', checkChecked);
checkallbtn.addEventListener('click', checkall);

//전부체크
function checkall(){
    if (checkallbtn.checked) {
        console.log(checkallbtn.checked);
        for (let i = 0; i < checks.length; i++) {
            checks[i].checked = true;
        }
    }else{
        console.log(checkallbtn.checked);
        for (let i = 0; i < checks.length; i++) {
            checks[i].checked = false;
        }
    }
}

//체크된 박스 배열에 담기
function checkChecked(){
    checkedBox = [];
    for (let i = 0; i < checks.length; i++) {
        if (checks[i].checked === true) {
            checkedBox.push(checks[i].parentElement.parentElement.children[1].children[0].innerText);
        }
    }
    console.log(checkedBox);
    console.log(`JSON : ${JSON.stringify(checkedBox)}`);
}

function delele(){
    const data = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json' 
        },
        body: JSON.stringify(checkedBox)
    }
    fetch('http://localhost:8090/erp_merge_v0.1/', data)
    //     .then(response => response.text())
    // .then(text => {
    //     console.log(text);
    //     delResult.innerHTML = text;
    // })
    ;
}
