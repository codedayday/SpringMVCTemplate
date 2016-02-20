<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="/js/vue/vue.js"></script>
</head>
<body>

<a href="http://cn.vuejs.org/api/">参考</a><br>

<script type="text/x-template" id="grid-template">
<table>
	<thead>
		<tr><th v-for="item in columns">
				<span>{{ item }}</span>
		</th></tr>
	</thead>
	<tbody>
		<tr v-for="entry in data">
			<td v-for="key in columns">
				{{ entry[key] }}
			</td>
		</tr>	
	</tbody>
</table>
</script>

<script type="text/javascript">
Vue.component({
	
})
var demo = new Vue({
	el : "#demo"
})
</script>
<div id="demo">
	<form>
		Search:<input v-model="searchQuery">
	</form>
</div>

</body>
</html>