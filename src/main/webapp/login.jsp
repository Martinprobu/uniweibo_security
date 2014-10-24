<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>团委微博管理系统</title>
	<link rel="stylesheet" href="css/lib/reset.css">
	<link rel="stylesheet" href="css/lib/base.css">
	<link rel="stylesheet" href="css/login.css">

	<script src="js/lib/jquery_min.js"></script>
	<script src="js/lib/highcharts.js"></script>
	<script src="js/common.js"></script>
	<script src="/js/lib/jQuery-url-extension.js"></script>
	<script src="js/login.js"></script>

	
</head>
<body>
	<div class="login_banner">
		<div class="login_ctn main_ctn_width">
			<img src="img/logo.png" alt="" id="logo">
			<form action="" id="login">
				<div>
					<h3>账号登录</h3>
					<p>
						<label for="username">
							<input type="text" name="username" id="username" placeholder="用户名">
						</label>
					</p>
					<p>
						<label for="password">
							<input type="password" name="password" id="password" placeholder="密码">
						</label>
					</p>
					<p>
						<label for="remember">
							<input type="checkbox" name="remember" id="remember">
							记住密码
						</label>
						<a href="javasctipt:;" class="forgot">忘记密码</a>
					</p>
					<p class="tips red">
						
					</p>
					<p>
						<button type="button" id="login_btn">登  录</button>
					</p>
				</div>
			</form>
		</div>
	</div>
	<div class="main_ctn_width clearfix">
		<div class="xl_top">
			<h2 class="top_title"><i class="icons xl_logo_s"></i>新浪微博活跃用户</h2>
			<div id="xl_person_top"></div>
			<div class="xl_wb_top">
				<h2 class="top_title"><i class="icons xl_logo_s"></i>新浪微博活跃博文</h2>

				<div class="single_wb">
					<img src="http://tp3.sinaimg.cn/2178873290/180/40032458931/1" alt="" class="avatar">
					<span class="name"><a href="http://weibo.com/u/2178873290">共青湖南 </a> <i class="icons xl_wb_icon bluev"></i></span>
					<div class="wb_text_ctn">
						<p class="wb_text">
							<a href="http://huati.weibo.com/k/%E6%8A%97%E6%B4%AA%E6%95%91%E7%81%BE%EF%BC%8C%E5%9B%A2%E5%9B%A2%E5%9C%A8%E8%A1%8C%E5%8A%A8?from=501">#抗洪救灾，团团在行动#</a>【全省各级团组织积极参与抗洪救灾】近期，受持续暴雨影响,我省部分市州遭受洪灾。各级团组织积极行动，组织团干、志愿者、义工等青年投入到了抗洪救灾当中。洪水无情人有情，只要我们齐心合力，众志成城，一定能克服困难，共渡难关！团省委将分批组织机关干部奔赴救灾一线！
						</p>
						<div class="wb_pic">
							<img src="http://ww4.sinaimg.cn/square/7232685fgw1eio2h7mkf6j20c60rkn1a.jpg" alt="">
							<img src="http://ww3.sinaimg.cn/square/7232685fgw1eio2inkdjzj21kw16o7ew.jpg" alt="">
						</div>
					</div>
					<div class="check_all"><a href="javascript:;">查看全文</a></div>	
					<div class="wb_option">
						<div class="right_option">
							<span>赞(0)</span>
							<span>转发(10)</span>
							<span>评论(1)</span>
						</div>
						<a href="http://weibo.com/2178873290/Be9NhaCEh?mod=weibotime" class="wb_time">7月24日 18:35</a>
					</div>
				</div>

				<div class="single_wb">
					<img src="http://tp4.sinaimg.cn/1915906143/50/40051800698/1" alt="" class="avatar">
					<span class="name"><a href="http://weibo.com/u/1915906143">我们是共青团祁阳县委</a> <i class="icons xl_wb_icon bluev"></i></span>
					<div class="wb_text_ctn">
						<p class="wb_text">
						为深入践行党的群众路线，帮助家境贫寒、品学兼优的大学新生顺利入学，祁阳团县委积极入户走访贫困大学新生进行调查摸底，推进助学项目顺利开展。详见长微博：<a href="http://weibo.com/n/%E5%85%B1%E9%9D%92%E5%9B%A2%E6%B0%B8%E5%B7%9E">@共青团永州</a> <a href="http://weibo.com/n/%E5%85%B1%E9%9D%92%E6%B9%96%E5%8D%97">@共青湖南</a>
						</p>
					</div>
					<div class="check_all"><a href="javascript:;">查看全文</a></div>	
					<div class="wb_option">
						<div class="right_option">
							<span>赞(5)</span>
							<span>转发(10)</span>
							<span>评论(1)</span>
						</div>
						<a href="http://weibo.com/1915906143/Bf4EIp0eJ" class="wb_time">7月24日 18:35</a>
					</div>
				</div>

				<div class="single_wb">
					<img src="http://tp4.sinaimg.cn/1915906143/50/40051800698/1" alt="" class="avatar">
					<span class="name"><a href="http://weibo.com/u/2104767612">共青团湘潭市委</a> <i class="icons xl_wb_icon bluev"></i></span>
					<div class="wb_text_ctn">
						<p class="wb_text">
						湘潭市“创建全国文明城市”办公室招聘暑期实习生工作圆满结束<img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/36/gza_org.gif" alt="">今天上午9点，由“创建办”、团市委领导共同组成的面试团队，对来自各大高校的54名大学生进行了和谐而又紧张的面试，最后选拔出14名优秀大学生，对他们的精彩表现表示祝贺！<img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/d8/good_org.gif" alt="">同时感谢大家的支持！谢谢！<img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/58/mb_org.gif" alt=""><a href="http://weibo.com/n/%E5%85%B1%E9%9D%92%E6%B9%96%E5%8D%97">@共青湖南</a>
						</p>
					</div>
					<div class="check_all"><a href="javascript:;">查看全文</a></div>
					<div class="wb_option">
						<div class="right_option">
							<span>赞(4)</span>
							<span>转发(10)</span>
							<span>评论(1)</span>
						</div>
						<a href="wb_time" class="wb_time">7月24日 18:35</a>
					</div>
				</div>

				<div class="single_wb">
					<img src="http://tp4.sinaimg.cn/1915906143/50/40051800698/1" alt="" class="avatar">
					<span class="name"><a href="http://weibo.com/yiyanggongqingtuan">益阳共青团</a> <i class="icons xl_wb_icon bluev"></i></span>
					<div class="wb_text_ctn">
						<p class="wb_text">
							<a href="http://huati.weibo.com/k/%E5%B8%8C%E6%9C%9B%E5%B7%A5%E7%A8%8B%E5%9C%86%E6%A2%A6%E8%A1%8C%E5%8A%A8%EF%BC%8C%E8%AE%A9%E7%88%B1%E5%BB%B6%E7%BB%AD?from=526">#希望工程圆梦行动，让爱延续#</a> <a href="http://t.cn/RPfMgAD">http://t.cn/RPfMgAD</a> 中国益阳门户网 <a href="http://weibo.com/n/%E7%9B%8A%E9%98%B3%E5%9C%A8%E7%BA%BFiyzx">@益阳在线iyzx</a> <a href="http://weibo.com/n/%E5%85%B1%E9%9D%92%E6%B9%96%E5%8D%97">@共青湖南</a> <a href="http://weibo.com/n/%E6%B9%96%E5%8D%97%E7%9C%81%E9%9D%92%E5%B0%91%E5%B9%B4%E5%8F%91%E5%B1%95%E5%9F%BA%E9%87%91%E4%BC%9A">@湖南省青少年发展基金会</a> <a href="http://t.cn/RPfMdFN">http://t.cn/RPfMdFN</a>
						</p>
					</div>
					<div class="check_all"><a href="javascript:;">查看全文</a></div>
					<div class="wb_option">
						<div class="right_option">
							<span>赞(9)</span>
							<span>转发(10)</span>
							<span>评论(1)</span>
						</div>
						<a href="http://weibo.com/1013382012/BfWEYa2q5" class="wb_time">7月24日 18:35</a>
					</div>
				</div>

				<div class="single_wb">
					<img src="http://tp4.sinaimg.cn/1915906143/50/40051800698/1" alt="" class="avatar">
					<span class="name"><a href="http://weibo.com/u/2104767612">共青团湘潭市委</a> <i class="icons xl_wb_icon bluev"></i></span>
					<div class="wb_text_ctn">
						<p class="wb_text">
							<a href="http://huati.weibo.com/k/%E5%A5%8B%E6%96%97%E7%9A%84%E9%9D%92%E6%98%A5%E6%9C%80%E7%BE%8E%E4%B8%BD?from=526">#奋斗的青春最美丽#</a>生活赋予我们一种巨大的和无限高贵的礼品，这就是青春：充满着力量，充满着期待志愿，充满着求知和斗争的志向，充满着希望信心和青春。<a href="http://weibo.com/n/%E5%85%B1%E9%9D%92%E6%B9%96%E5%8D%97">@共青湖南</a>
						</p>
					</div>
					<div class="check_all"><a href="javascript:;">查看全文</a></div>
					<div class="wb_option">
						<div class="right_option">
							<span>赞(10)</span>
							<span>转发(10)</span>
							<span>评论(1)</span>
						</div>
						<a href="http://weibo.com/2104767612/BeHTKgk86?mod=weibotime" class="wb_time">7月24日 18:35</a>
					</div>
				</div>

			</div>
		</div>
		<div class="tx_top">
			<h2 class="top_title"><i class="icons tx_logo_s"></i>腾讯微博活跃用户</h2>
			<div id="tx_person_top"></div>
			<div class="xl_wb_top">
				<h2 class="top_title"><i class="icons tx_logo_s"></i>腾讯微博活跃博文</h2>

				<div class="single_wb">
					<img src="http://tp3.sinaimg.cn/2178873290/180/40032458931/1" alt="" class="avatar">
					<span class="name"><a href="http://t.qq.com/hunangongqing">共青湖南</a> <i class="icons tx_wb_icon bluev"></i></span>
					<div class="wb_text_ctn">
						<p class="wb_text">
						<a href="http://k.t.qq.com/k/%E6%8A%97%E6%B4%AA%E6%95%91%E7%81%BE%EF%BC%8C%E5%9B%A2%E5%9B%A2%E5%9C%A8%E8%A1%8C%E5%8A%A8">#抗洪救灾，团团在行动#</a>【全省各级团组织积极参与抗洪救灾】近期，受持续暴雨影响,我省部分市州遭受洪灾。各级团组织积极行动，组织团干、志愿者、义工等青年投入到了抗洪救灾当中。洪水无情人有情，只要我们齐心合力，众志成城，一定能克服困难，共渡难关！团省委将分批组织机关干部奔赴救灾一线！
						</p>
					</div>
					<div class="check_all"><a href="javascript:;">查看全文</a></div>
					<div class="wb_option">
						<div class="right_option">
							<span>赞(3)</span>
							<span>转播(10)</span>
							<span>评论(1)</span>
						</div>
						<a href="http://t.qq.com/p/t/418249114981125" class="wb_time">7月24日 18:35</a>
					</div>
				</div>

				<div class="single_wb">
					<img src="http://tp4.sinaimg.cn/1915906143/50/40051800698/1" alt="" class="avatar">
					<span class="name"><a href="http://t.qq.com/hunangongqing">长沙共青团</a> <i class="icons tx_wb_icon bluev"></i></span>
					<div class="wb_text_ctn">
						<p class="wb_text">
							<a href="http://k.t.qq.com/k/%E6%88%91%E4%B8%BA%E6%A0%B8%E5%BF%83%E4%BB%B7%E5%80%BC%E8%A7%82%E4%BB%A3%E8%A8%80%C2%B7%E5%8C%97%E5%A4%A7%E5%AD%A6%E5%AD%90%E5%AF%B9%E8%AF%9D%E9%95%BF%E6%B2%99%E9%9D%92%E5%B9%B4">#我为核心价值观代言·北大学子对话长沙青年#</a>活动结束后，同学们纷纷争抢和何市长合影留念。何市长历来十分关心北大清华见习计划，今天的讲话更是让同学们受益匪浅。<a href="http://t.qq.com/txdaxiang">@大湘网</a> <a href="http://t.qq.com/hunangongqing">@湖南共青团</a> <a href="http://t.qq.com/hncswb">@长沙晚报</a> <a href="http://t.qq.com/y18hnu">@湖南大学团委</a>
						</p>
					</div>
					<div class="check_all"><a href="javascript:;">查看全文</a></div>
					<div class="wb_option">
						<div class="right_option">
							<span>赞(5)</span>
							<span>转播(10)</span>
							<span>评论(1)</span>
						</div>
						<a href="http://t.qq.com/p/t/423751101045990"  class="wb_time">7月24日 18:35</a>
					</div>
				</div>

				<div class="single_wb">
					<img src="http://tp4.sinaimg.cn/1915906143/50/40051800698/1" alt="" class="avatar">
					<span class="name"><a href="http://t.qq.com/hunangongqing">益阳共青团</a> <i class="icons tx_wb_icon bluev"></i></span>
					<div class="wb_text_ctn">
						<p class="wb_text">
							<a href="http://p.t.qq.com/longweibo/page.php?lid=18435308854987132206">【职场礼仪支招】实用的餐桌礼仪</a>【职场礼仪支招】职场餐桌上，不但要吃得尽兴，也要举止得体。入座的顺序和位置有什么讲究？席间要注意哪些细节？西餐餐具如何正确使用？给你支招实用的餐桌礼仪！
						</p>
					</div>
					<div class="check_all"><a href="javascript:;">查看全文</a></div>
					<div class="wb_option">
						<div class="right_option">
							<span>赞(8)</span>
							<span>转播(10)</span>
							<span>评论(1)</span>
						</div>
						<a href="http://p.t.qq.com/longweibo/page.php?lid=18435308854987132206" class="wb_time">7月24日 18:35</a>
					</div>
				</div>

				<div class="single_wb">
					<img src="http://tp4.sinaimg.cn/1915906143/50/40051800698/1" alt="" class="avatar">
					<span class="name"><a href="http://t.qq.com/xtgqt58583122">湘潭共青团 </a><i class="icons tx_wb_icon bluev"></i></span>
					<div class="wb_text_ctn">
						<p class="wb_text">
							湘潭市“创建全国文明城市”办公室招聘暑期实习生工作圆满结束 <img src="http://mat1.gtimg.com/www/mb/images/face/99.gif" alt="">今天上午9点，由“创建办”、团市委领导共同组成的面试团队，对来自各大高校的54名大学生进行了和谐而又紧张的面试，最后选拔出14名优秀大学生，对他们的精彩表现表示祝贺！ <img src="http://mat1.gtimg.com/www/mb/images/face/76.gif" alt="">同时感谢大家的支持！谢谢！ <img src="http://mat1.gtimg.com/www/mb/images/face/63.gif" alt=""> <a href="http://t.qq.com/hunangongqing">@湖南共青团</a>
						</p>
					</div>
					<div class="check_all"><a href="javascript:;">查看全文</a></div>
					<div class="wb_option">
						<div class="right_option">
							<span>赞(7)</span>
							<span>转播(10)</span>
							<span>评论(1)</span>
						</div>
						<a href="http://t.qq.com/p/t/413784105458349" class="wb_time">7月24日 18:35</a>
					</div>
				</div>

				<div class="single_wb">
					<img src="http://tp4.sinaimg.cn/1915906143/50/40051800698/1" alt="" class="avatar">
					<span class="name"><a href="http://t.qq.com/hengyanggongqingtuan">湘潭共青团 </a><i class="icons tx_wb_icon bluev"></i></span>
					<div class="wb_text_ctn">
						<p class="wb_text">
							【志愿之火再添薪---共青团衡阳市委召开"2014年西部计划志愿者迎新会"】7.25日下午，共青团衡阳市委召开"2014年衡阳市西部计划志愿者迎新会"。共青团衡阳市委副书记范苏媛出席会议。各县市区服务单位代表及志愿者参加会议。
						</p>
					</div>
					<div class="check_all"><a href="javascript:;">查看全文</a></div>
					<div class="wb_option">
						<div class="right_option">
							<span>赞(32)</span>
							<span>转播(10)</span>
							<span>评论(1)</span>
						</div>
						<a href="http://t.qq.com/p/t/419768044380764" class="wb_time">7月24日 18:35</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="footer">
		<div class="main_ctn_width">
			<p>版权</p>
		</div>
	</div>
	<div class="cover"></div>
	<div class="pop_box" id="forgot">
		<div class="title">忘记密码<i class="icons close fr"></i></div>
		<div class="pop_ctn">
			<div>
				<label for="">用户名</label>
				<input class="input_normal" type="text" name="" id="" checked="chedced">			
			</div>
			<div>
				<label for="">验证码</label>
				<input class="input_normal" type="text" name="" id="">
			</div>
			<div>
				<img class="check_img" src="img/check.png" alt="">
				<a href="javascript:;">换一张</a>
			</div>
			<div class="">
				<button class="red_btn close">确定</button>
			</div>
		</div>
	</div>
</body>
<script>
	$(function(){
		showPop($('.forgot'),$('#forgot'));
	});
</script>
</html>