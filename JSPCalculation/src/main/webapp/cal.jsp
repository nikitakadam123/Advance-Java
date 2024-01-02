<%

int num1 =Integer.parseInt(request.getParameter("num1"));
int num2 =Integer.parseInt(request.getParameter("num2"));

int tot=num1+num2;

out.println(String.valueOf(tot));
%>