/**
 * 
 */
const MONTHS = [
  'January',
  'February',
  'March',
  'April',
  'May',
  'June',
  'July',
  'August',
  'September',
  'October',
  'November',
  'December'
];

function formatCurrency(value) {
	return new Intl.NumberFormat('en-IE', { 
		style: 'currency', 
		currency: 'EUR' 
	}).format(value);
}

function getMonth(monthNumber) {
//	var months = [ "January", "February", "March", "April", "May", "June", 
//         "July", "August", "September", "October", "November", "December" ];

	return MONTHS[monthNumber-1];
}