<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" type="text/css" href="/assets/user/css/xe16.css">
<script src="/Web_Dat_Ve_Xe_Khach/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/Web_Dat_Ve_Xe_Khach/js/xe.js"></script>
<script>
	$(document)
			.ready(
					function() {
						$("#btnPrint")
								.click(
										function() {
											var divContents = $("body").html();
											var printWindow = window.open('',
													'', 'height=400,width=800');
											printWindow.document
													.write('<html><head><title>DIV Contents</title>');
											printWindow.document
													.write('</head><body >');
											printWindow.document
													.write(divContents);
											printWindow.document
													.write('</body></html>');
											printWindow.document.close();
											printWindow.print();
										});
					});
	
	function choose1(id) {
		const div1 = document.getElementsByClassName('ghe')[0];
		var idGhe = div1.getAttribute('id');
		console.log(id)

	}
</script>
</head>
<body>
	<div>
		<img id="img-16" style="float: left; clear: right;" alt="Chu Thich"
			src="../assets/user/images/ghes.png">
		<div id="xe16cho" style="position: relative;">

			<%
			/* int idChuyen = (Integer) session.getAttribute("chuyen");
			Chuyen chuyen = null;
			if (idChuyen == 1) {
				chuyen = (Chuyen) session.getAttribute("chuyenDi");
			} else {
				chuyen = (Chuyen) session.getAttribute("chuyenVe");
			}
			List<Ghe> danhSachghe = chuyen.getDanhSachGheNgoi(); */
			%>

			<input type="hidden" value="" id="idChuyen" /> <img alt="dauxe"
				src="../assets/user/images/p.png" width="260px" height="150px">
			<%
			for (int i = 0; i < 15; i++) {
				int hang = 0;
				int cot = 0;

				switch (i) {
				case 0:
				case 1:
					hang = 0;
					break;
				case 2:
				case 3:
				case 4:
					hang = 1;
					break;
				case 5:
				case 6:
				case 7:
					hang = 2;
					break;
				case 8:
				case 9:
				case 10:
					hang = 3;
					break;
				case 11:
				case 12:
				case 13:
				case 14:
					hang = 4;
					break;
				default:
					break;
				}
				switch (i) {
				case 2:
				case 5:
				case 8:
				case 11:

					cot = 0;
					break;
				case 0:
				case 3:
				case 6:
				case 9:
				case 12:
					cot = 1;
					break;
				case 1:
				case 4:
				case 7:
				case 10:
				case 13:
					cot = 2;
					break;
				default:
					cot = 3;
					break;
				}
				/* if (danhSachghe.get(i).getTrangThai() == Ghe.DA_DAT) */ {
			%>
			<img alt="ghe<%=i%>" src="../assets/user/images/ghe3.png" id="<%=i%>"
				class="ghe hang<%=hang%> cot<%=cot%> a" onclick="choose1(<%=i%>)"
				name="<%=i%>" />

			<%
			}
			/* else if (danhSachghe.get(i).getTrangThai() == Ghe.CHUA_DAT)  */ {
			%>
			<img alt="ghe<%=i%>" src="../assets/user/images/ghe1.png" id="<%=i%>"
				class="ghe chuadat hang<%=hang%> cot<%=cot%> b"
				onclick="choose1(<%=i%>)" name="<%=i%>" />
			<%
			}
			/* else */ {
			%>
			<img alt="ghe<%=i%>" src="../assets/user/images/ghe2.png" id="<%=i%>"
				class="ghe danggiu hang<%=hang%> cot<%=cot%> c"
				onclick="choose1(<%=i%>)" name="<%=i%>" />
			<%
			}
			}
			%>

		</div>
	</div>


</body>
</html>