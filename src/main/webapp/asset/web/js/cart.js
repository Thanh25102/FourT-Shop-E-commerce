const getCarts = (username) => {
    fetch(`/FourT_Shop_E_commerce_war/api/v1/cart/${username}`)
        .then(res => res.json())
        .then(data =>{
            let cartElements = document.getElementById('carts_fourt')
            if(data.status === 'ok'){
                let sumPrice = 0
                let html = ''
                data.data.forEach(cart=>{
                    sumPrice += cart.price
                    html += `
                        <tr>
                            <td>
                                <div class="media">
                                    <div class="d-flex">
                                        <img src="${cart.productImage}" alt="">
                                    </div>
                                    <div class="media-body">
                                        <p>${cart.productName}</p>
                                    </div>
                                </div>
                            </td>
                            <td>
                                <h5>$360.00</h5>
                            </td>
                            <td>
                                <div class="product_count">
                                    <input type="text" name="qty" id="sst" maxlength="12" value="${cart.quantity}" title="Quantity:"
                                           class="input-text qty">
                                    <button onclick="var result = document.getElementById('sst'); var sst = result.value; if( !isNaN( sst )) result.value++;return false;"
                                            class="increase items-count" type="button"><i class="lnr lnr-chevron-up"></i></button>
                                    <button onclick="var result = document.getElementById('sst'); var sst = result.value; if( !isNaN( sst ) &amp;&amp; sst > 0 ) result.value--;return false;"
                                            class="reduced items-count" type="button"><i class="lnr lnr-chevron-down"></i></button>
                                </div>
                            </td>
                            <td>
                                <h5>$${cart.price}</h5>
                            </td>
                        </tr>
                    `
                })
                cartElements.innerHTML = html
                document.getElementById('sum_price').innerText = `$${sumPrice}`
            }else {
                swal(`khoong co san pham nao, nho xu ly cho nay nha :>`)
            }
        })
}