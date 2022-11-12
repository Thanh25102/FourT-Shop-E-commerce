function filterByPrice(url) {
	let lower = document.querySelector('.noUi-handle-lower').ariaValueText;
	let upper = document.querySelector('.noUi-handle-upper').ariaValueText;
	url += `&&priceStart=${lower}&&priceEnd=${upper}`;
	window.location.href = url;
}
function addToBag(productId, isLogin) {
	let options = {
		method: 'POST',
		Headers: {
			'Content-Type': 'application/json'
		},
	}
	if (isLogin === true) {
		fetch(`/FourT-Shop-E-commerce/api/v1/cart/${productId}`, options)
			.then((response) => response.json())
			.then((data) => {
				updateQuantityCart()
				alert(data.message)
			})
			.catch((e) => console.log(e))
	} else {
		alert('you need login')
	}
}
function removeProductFromCart(cartDetailId) {
	let options = {
		method: 'DELETE',
		Headers: {
			'Content-Type': 'application/json'
		},
	}
	fetch(`/FourT-Shop-E-commerce/api/v1/cart/${cartDetailId}`, options)
		.then((response) => response.json())
		.then((data) => {
			alert(data.message)
			document.getElementById(`cart_item_${cartDetailId}`).remove();
			updateQuantityCart()
		})
		.catch((e) => console.log(e))
}

function updateQuantityCart() {
	let options = {
		method: 'GET',
		Headers: {
			'Content-Type': 'application/json'
		},
	}
	fetch(`/FourT-Shop-E-commerce/api/v1/cart/quantity`, options)
		.then((response) => response.json())
		.then((data) => {
			console.log(data)
			if (data.status === 'ok') {
				document.getElementById('quantity_product').innerText = data.data
			}
		})
		.catch((e) => console.log(e))
}
updateQuantityCart()

function openOrderDetail(orderId) {
	let orderDetailElement = document.getElementById(`order_detail_${orderId}`)
	if (orderDetailElement.style.display === 'block') {
		orderDetailElement.style.display = 'none'
	} else {
		orderDetailElement.style.display = 'block'
	}
}

function updateQuantityCartDetail(id,type){
	let options = {
		method: 'POST',
		Headers: {
			'Content-Type': 'application/json'
		},
	}
	fetch(`/FourT-Shop-E-commerce/api/v1/cart/quantity/${id}?type=${type}`, options)
		.then((response) => response.json())
		.then((data) => {
			console.log(data)
			if (data.status === 'ok') {
				let USDollar = new Intl.NumberFormat('en-US', {
				    style: 'currency',
				    currency: 'USD',
				});
				document.getElementById(`cart_detail_price_${id}`).innerText = USDollar.format(data.data.price)
				document.getElementById(`quantity_cart_detail_${id}`).value = data.data.quantity
			}
		})
		.catch((e) => console.log(e))
}

function proceedCheckOut(currentUser){
	let options = {
		method: 'POST',
		Headers: {
			'Content-Type': 'application/json'
		},
	}
	fetch(`/FourT-Shop-E-commerce/api/v1/cart/quantity/${id}?type=${type}`, options)
		.then((response) => response.json())
		.then((data) => {
			console.log(data)
			if (data.status === 'ok') {
				let USDollar = new Intl.NumberFormat('en-US', {
				    style: 'currency',
				    currency: 'USD',
				});
				document.getElementById(`cart_detail_price_${id}`).innerText = USDollar.format(data.data.price)
				document.getElementById(`quantity_cart_detail_${id}`).value = data.data.quantity
			}
		})
		.catch((e) => console.log(e))
}

