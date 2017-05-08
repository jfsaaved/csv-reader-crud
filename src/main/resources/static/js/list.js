$(function() {
	$('input[name="dateRange"]').daterangepicker({
		timePicker: true,
		timePickerSeconds: true,
		timePicker24Hour: true,
		locale: {
			format: 'MM/DD/YYYY HH:mm:ss'
		}
	});
});

function filterChartByDateRange() {
	yVal = document.getElementById('yId').value;
	range = document.getElementById('dateRange').value;
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?yVal=" + yVal + "&dateRange=" + range );
}

function changeDataPerPage() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = document.getElementById('sort').value;
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function filterByDateRange() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value; 
	range = document.getElementById('dateRange').value;
	sort = document.getElementById('sort').value;
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function sortByGmtDateFirst() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = 'ByGmtDateFirst';
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function sortByGmtDateLast() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = 'ByGmtDateLast';
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function sortByGmtTimeFirst() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = 'ByGmtTimeFirst';
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function sortByGmtTimeLast() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = 'ByGmtTimeLast';
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function sortByGpsLatFirst() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = 'ByGpsLatFirst';
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function sortByGpsLatLast() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = 'ByGpsLatLast';
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function sortByGpsLongFirst() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = 'ByGpsLongFirst';
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function sortByGpsLongLast() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = 'ByGpsLongLast';
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function sortByVocsFirst() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = 'ByVocsFirst';
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function sortByVocsLast() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = 'ByVocsLast';
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function sortByMs3First() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = 'ByMs3First';
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function sortByMs3Last() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = 'ByMs3Last';
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function sortByHydroSulfFirst() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = 'ByHydroSulfFirst';
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function sortByHydroSulfLast() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = 'ByHydroSulfLast';
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function sortByMethaneFirst() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = 'ByMethaneFirst';
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function sortByMethaneLast() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = 'ByMethaneLast';
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function sortByMs2First() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = 'ByMs2First';
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function sortByMs2Last() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = 'ByMs2Last';
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function sortByAmmoniaFirst() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = 'ByAmmoniaFirst';
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function sortByAmmoniaLast() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = 'ByAmmoniaLast';
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function sortByWindSpdFirst() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = 'ByWindSpdFirst';
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function sortByWindSpdLast() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = 'ByWindSpdLast';
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function sortByWindDirFirst() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = 'ByWindDirFirst';
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function sortByWindDirLast() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = 'ByWindDirLast';
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function sortByRainFirst() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = 'ByRainFirst';
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function sortByRainLast() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = 'ByRainLast';
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function sortBySolarSensorFirst() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = 'BySolarSensorFirst';
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function sortBySolarSensorLast() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = 'BySolarSensorLast';
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function sortByUvSensorFirst() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = 'ByUvSensorFirst';
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function sortByUvSensorLast() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = 'ByUvSensorLast';
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function sortByBarometricFirst() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = 'ByBarometricFirst';
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function sortByBarometricLast() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = 'ByBarometricLast';
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function sortByInternalTempFirst() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = 'ByInternalTempFirst';
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function sortByInternalTempLast() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = 'ByInternalTempLast';
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function sortByInternalHumidFirst() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = 'ByInternalHumidFirst';
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function sortByInternalHumidLast() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = 'ByInternalHumidLast';
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function sortByExternalTempFirst() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = 'ByExternalTempFirst';
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function sortByExternalTempLast() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = 'ByExternalTempLast';
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function sortByExternalHumidFirst() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = 'ByExternalHumidFirst';
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function sortByExternalHumidLast() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = 'ByExternalHumidLast';
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function sortByOdourUnitFirst() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = 'ByOdourUnitFirst';
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}

function sortByOdourUnitLast() {
	page = document.getElementById('page').value; 
	size = document.getElementById('size').value;
	range = document.getElementById('dateRange').value;
	sort = 'ByOdourUnitLast';
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?page=" + page + "&dateRange=" + range + "&sort=" + sort + "&size=" + size);
}