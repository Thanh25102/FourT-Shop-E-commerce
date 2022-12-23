async function downloadExcel(filename,model) {
	try {
		const response = await fetch(`/FourT-Shop-E-commerce/admin/export-revenue-excel?filename=${filename}&&model=${model}`, {
			method: 'GET',
			headers: {
				'Content-Type': 'application/octet-stream'
			}
		});
		const data = await response.blob();
		const downloadUrl = window.URL.createObjectURL(data);
		const link = document.createElement('a');
		link.href = downloadUrl;
		link.download = `${filename}.xlsx`;
		link.click();
	} catch (error) {
		console.error(error);
	}
}

const link = document.getElementById('download-link');
link.addEventListener('click', function(event) {
	downloadExcel("revenue","revenue");
	event.preventDefault();
});