
<%@page import="java.util.List"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" type="text/css" href="/assets/user/css/xe16.css">
<script src="../js/jquery-1.11.1.min.js"></script>
<script src="../js/xe.js"></script>
<script>
</script>
</head>
<body>
	<%
	/* int idChuyens = (Integer) session.getAttribute("chuyen");
	Chuyen chuyens = null;
	if (idChuyens == 1) {
		chuyens = (Chuyen) session.getAttribute("chuyenDi");
	} else {
		chuyens = (Chuyen) session.getAttribute("chuyenVe");
	}
	List<Ghe> danhSachghes = chuyens.getDanhSachGheNgoi(); */
	%>
	<input type="hidden" value="" id="idChuyen" />
	<img style="float: left; clear: right;" alt="Chu Thich" src="../assets/user/images/ghes.png">
	<div id="xe45cho">
		<img alt="dauxe" src="../assets/user/images/p.png" width="310px"
			height="100px">
		<%
			for (int i = 0; i < 40; i++) {
				int hang = i / 4;
				int cot = i % 4;
				/* if (danhSachghes.get(i).getTrangThai() == Ghe.DA_DAT) */ {
		%>
		<img alt="ghe<%=i%>" src="../assets/user/images/ghe3.png" id="<%=i%>"
			class="ghe hang<%=hang%> cot<%=cot%>" />
		<%
			} /* else */ {
		%>
		<img alt="ghe<%=i%>" src="../assets/user/images/ghe1.png" id="<%=i%>"
			class="ghe chuadat hang<%=hang%> cot<%=cot%>" />
		<%
			}
			}
			for (int i = 40; i < 45; i++) {
				int hang = 10;
				int cot = i % 5;
				/* if (danhSachghes.get(i).getTrangThai() == Ghe.DA_DAT) */ {
		%>
		<img alt="ghe<%=i%>" src="../assets/user/images/ghe3.png" id="<%=i%>"
			class="ghe hang<%=hang%> cot<%=cot%>" />
		<%
			} /* else */ {
		%>
		<img alt="ghe<%=i%>" src="../assets/user/images/ghe1.png" id="<%=i%>"
			class="ghe chuadat hang<%=hang%> cot1-<%=cot%>" />
		<%
			}
			}
		%>
	</div>

</body>
</html>