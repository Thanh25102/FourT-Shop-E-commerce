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
				swal(data.message)
			})
			.catch((e) => console.log(e))
	} else {
		swal('YOU NEED LOGIN')
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

function updateQuantityCartDetail(id, type) {
	let options = {
		method: 'POST',
		Headers: {
			'Content-Type': 'application/json'
		},
	}
	loading();

	async function callApi() {
		try {
			const response = await fetch('/FourT-Shop-E-commerce/api/v1/cart/sum-money');
			const data = await response.json();
			// Làm gì đó với dữ liệu trả về từ API
			let USDollar = new Intl.NumberFormat('en-US', {
				style: 'currency',
				currency: 'USD',
			});
			let sumPrice = document.getElementById('sum_price');
			sumPrice.innerHTML = USDollar.format(`${data.data}`)
		} catch (error) {
			console.error(error);
		}
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
				document.getElementById(`cart_detail_price_${id}`).innerText = USDollar.format(data.data.priceNew * data.data.quantity)
				document.getElementById(`sst quantity_cart_detail_${id}`).value = data.data.quantity
				callApi();
			}
		})
		.catch((e) => console.log(e))
		.finally(() => {
			removeLoading()
		})

}

function loading() {
	// Lấy nội dung HTML cần thêm vào
	var html = `
			<div id="overlay" style="position: fixed; top: 0; left: 0; width: 100%; height: 100%;  z-index: 99999;">
			  <div style="position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%);">
			  	<div class="loadingio-spinner-spin-qsao3u2fs2"><div class="ldio-1v00vxo0jgl">
					<div><div></div></div><div><div></div></div><div><div></div></div><div><div></div></div><div><div></div></div><div><div></div></div><div><div></div></div><div><div></div></div>
					</div>
				</div>
			  </div>
			</div>`;

	// Lấy thẻ body
	var body = document.getElementsByTagName('body')[0];

	// Tạo một thẻ div mới
	var div = document.createElement('div');
	div.innerHTML = html;
	// Thêm thẻ div vào trong thẻ body
	body.appendChild(div);
}
function removeLoading() {
	let remvoveElement = document.getElementById("overlay")
	remvoveElement.parentNode.removeChild(remvoveElement)
}



