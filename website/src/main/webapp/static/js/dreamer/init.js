;var o={init:function(){this.diagram()},random:function(e,t){return Math.floor(Math.random()*(t-e+1)+e)},diagram:function(){var e=Raphael("diagram",600,600),t=73,n="- Click -",r=250;e.circle(300,300,85).attr({stroke:"none",fill:"#e44d26"});var i=e.text(300,300,n).attr({font:"24px PT Sans",fill:"#fff"}).toFront();e.customAttributes.arc=function(e,t,n){var r=3.6*e,i=r==360?359.99:r,s=o.random(91,240),u=(s-i)*Math.PI/180,a=s*Math.PI/180,f=300+n*Math.cos(a),l=300-n*Math.sin(a),c=300+n*Math.cos(u),h=300-n*Math.sin(u),p=[["M",f,l],["A",n,n,0,+(i>180),1,c,h]];return{path:p,stroke:t}};$(".get").find(".arc").each(function(s){var o=$(this),u=o.find(".color").val(),a=o.find(".percent").val(),f=o.find(".text").text();t+=30;var l=e.path().attr({arc:[a,u,t],"stroke-width":26});l.mouseover(function(){this.animate({"stroke-width":50,opacity:.75},1e3,"elastic");if(Raphael.type!="VML")this.toFront();i.stop().animate({opacity:0},r,">",function(){this.attr({text:f+"\n"+a+"%"}).animate({opacity:1},r,"<")})}).mouseout(function(){this.stop().animate({"stroke-width":26,opacity:1},r*4,"elastic");i.stop().animate({opacity:0},r,">",function(){i.attr({text:n}).animate({opacity:1},r,"<")})})})}};$(function(){o.init()});