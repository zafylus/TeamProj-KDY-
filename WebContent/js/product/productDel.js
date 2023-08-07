
const checks = document.getElementsByClassName('check');
const delbtn = document.getElementById('delbtn');
const checkallbtn = document.getElementById('checkall');
let checkedBox = [];

delbtn.addEventListener('click', checkChecked);
checkallbtn.addEventListener('click', checkall);

// if (checkedBox.length === 0 ) {
//     delbtn.setAttribute('disabled', true)
// }else{
//     delbtn.removeAttribute('disabled');
// }
//전부체크
function checkall(){
    if (checkallbtn.checked) {
        console.log(checkallbtn.checked);
        for (let i = 0; i < checks.length; i++) {
            checks[i].checked = true;
            // delbtn.removeAttribute('disabled');
        }
    }else{
        console.log(checkallbtn.checked);
        for (let i = 0; i < checks.length; i++) {
            checks[i].checked = false;
            // delbtn.setAttribute('disabled', true)
        }
    }
}

//체크된 박스 배열에 담기
function checkChecked(){
    let delConfirm = confirm(`정말 삭제하시겠습니까?`);
    console.log(delConfirm);
    checkedBox = [];
    
    for (let i = 0; i < checks.length; i++) {
        if (checks[i].checked === true) {
            checkedBox.push(checks[i].parentElement.parentElement.children[1].children[0].innerText);
        }
    }

    // if (checkedBox.length === 0 ) {
    //     delbtn.setAttribute('disabled', true)
    // }else{
    //     delbtn.removeAttribute('disabled');
    // }
    
    console.log(checkedBox);
    console.log(`JSON : ${JSON.stringify(checkedBox)}`);
    
    if (delConfirm && checkedBox.length > 0) {
	    console.log('deleteProduct Function');

        const data = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json' 
            },
            body: JSON.stringify(checkedBox)
        }
        //http://localhost:8090/erp_merge_v0.1/product-delete
        fetch('product-delete', data)
            .then(() => {
                console.log('refresh');
                location.reload();
                // location.href='http://localhost:8090/erp_merge_v_0.1/product'
         });    
    } else {
        alert('삭제가 취소되었습니다.');
    }
}


// 