function filterByPrice(url){
    let lower = document.querySelector('.noUi-handle-lower').ariaValueText;
    let upper = document.querySelector('.noUi-handle-upper').ariaValueText;
    url += `&&priceStart=${lower}&&priceEnd=${upper}`;
    window.location.href = url;
}