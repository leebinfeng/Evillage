<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="assets/images/logo.gif">
    <title>户籍证明办理</title>
</head>
<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/certificate.css">
<body>
<!-- Fixed navbar -->
<nav class="navbar navbar-inverse navbar-static-top bs-docs-nav">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <img alt="Brand" src="assets/images/logo.gif" class="navbar-brand">

            <a class="navbar-brand" href="/index">
                民兴村电子村务
            </a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">首页</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                       aria-haspopup="true" aria-expanded="false">公共服务 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li role="separator" class="divider"></li>
                        <li class="dropdown-header">日常服务</li>
                        <li><a href="#">户籍证明</a></li>
                        <li><a href="#">报建申请</a></li>
                        <li><a href="#">医保管理</a></li>
                        <li><a href="#">土地登记</a></li>
                        <li role="separator" class="divider"></li>
                        <li class="dropdown-header">其他服务</li>
                        <li><a href="#">建议监督</a></li>
                        <li><a href="#">调解申请</a></li>
                    </ul>
                </li>
                <li><a href="#about">公共信息</a></li>
                <li><a href="#about">农业服务</a></li>
                <li><a href="#contact">民兴论坛</a></li>
                <li><a href="#">走进民兴</a></li>
                <li><a href="#">关于</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">注册</a></li>
                <li><a href="#">|</a></li>
                <li><a href="#">登录</a></li>
            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
</nav>



<div class="container">
    <h1 class="page-header">
        预约流程
    </h1>
    <div class="row">
        <div class="col-sm-3 col-md-3">
            <div class="thumbnail">
                <img src="assets/icons/png/Chat.png" alt="first-step">
                <div class="caption">
                    <h3>步骤一</h3>
                    <p>在网站或者手机客户端登录,填写预约相关信息</p>
                </div>
            </div>
        </div>
        <div class="col-sm-1 col-md-1 step-arrow">
            <span class="fa fa-chevron-right fa-3x" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </div>
        <div class="col-sm-3 col-md-3">
            <div class="thumbnail">
                <img src="assets/icons/png/Mail.png" alt="first-step">
                <div class="caption">
                    <h3>步骤二</h3>
                    <p>在网站或者手机客户端登录,填写预约相关信息</p>
                </div>
            </div>
        </div>
        <div class="col-sm-1 col-md-1 step-arrow">
            <span class="fa fa-chevron-right fa-3x" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </div>
        <div class="col-sm-3 col-md-3">
            <div class="thumbnail">
                <img src="assets/icons/png/Retina-Ready.png" alt="first-step">
                <div class="caption">
                    <h3>步骤三</h3>
                    <p>在网站或者手机客户端登录,填写预约相关信息</p>
                </div>
            </div>
        </div>
        <div class="col-sm-1 col-md-1">
        </div>
    </div>

    <h1 class="page-header">
        预约服务选择
    </h1>

    <div class="tabbable row"> <!-- Only required for left/right tabs -->
        <ul class="nav nav-pills nav-stacked col-md-3">
            <li class="active"><a href="#tab1" data-toggle="tab">预约户籍证明办理</a></li>
            <li><a href="#tab2" data-toggle="tab">预约房屋报建办理</a></li>
        </ul>
        <div class="tab-content col-md-9">
            <div class="tab-pane active" id="tab1">
                <form class="form-horizontal" method="post">
                    <div class="form-group">
                        <label class="col-sm-3 col-md-3 control-label" for="reservationTime">预约办理时间</label>

                        <div class="col-sm-5 col-md-5">
                            <input type="date" class="form-control" id="reservationTime" required>
                        </div>
                        <div class="col-sm-4 col-md-4">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="certificateType" class="col-sm-3 col-md-3 control-label">户籍证明类型</label>

                        <div class="col-sm-5 col-md-5">
                            <select id="certificateType" class="form-control" required>
                                <option>户籍迁入证明</option>
                                <option>户籍迁出证明</option>
                            </select>
                        </div>
                        <div class="col-sm-4 col-md-4">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="checkWay" class="col-sm-3 col-md-3 control-label">户籍证明类型</label>

                        <div class="col-sm-5 col-md-5">
                            <select id="checkWay" class="form-control" required>
                                <option>现场办理</option>
                                <option>网络办理</option>
                            </select>
                        </div>
                        <div class="col-sm-4 col-md-4">
                        </div>
                    </div>
                    <div class="form-group has-feedback">
                        <label for="telephone" class="col-sm-3 col-md-3 control-label">手机号码</label>
                        <div class="col-sm-5 col-md-5">
                            <input class="form-control" id="telephone" required>
                            <span class="glyphicon glyphicon-earphone form-control-feedback" aria-hidden="true"></span>
                        </div>
                        <div class="col-sm-4 col-md-4">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-4 col-md-4"></div>
                        <div class="col-sm-4 col-md-4">
                            <input class="btn btn-primary" type="submit" value="我要预约">
                        </div>
                        <div class="col-sm-4 col-md-4"></div>
                    </div>
                </form>
            </div>

            <div class="tab-pane" id="tab2">
                <form class="form-horizontal" method="post">
                    <div class="form-group">
                        <label class="col-sm-3 col-md-3 control-label" for="reserveConstructionTime">预约办理时间</label>

                        <div class="col-sm-5 col-md-5">
                            <input type="date" class="form-control" id="reserveConstructionTime" required>
                        </div>
                        <div class="col-sm-4 col-md-4">

                        </div>
                    </div>
                    <div class="form-group">
                        <label for="constructionType" class="col-sm-3 col-md-3 control-label">报建申请类型</label>

                        <div class="col-sm-5 col-md-5">
                            <select id="constructionType" class="form-control" required>
                                <option>住宅报建申请</option>
                                <option>水利报建申请</option>
                                <option>农业用地报建申请</option>
                            </select>
                        </div>
                        <div class="col-sm-4 col-md-4">

                        </div>
                    </div>
                    <div class="form-group has-feedback">
                        <label for="telephone2" class="col-sm-3 col-md-3 control-label">手机号码</label>
                        <div class="col-sm-5 col-md-5">
                            <input class="form-control" id="telephone2" required>
                            <span class="glyphicon glyphicon-earphone form-control-feedback" aria-hidden="true"></span>
                        </div>
                        <div class="col-sm-4 col-md-4">

                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-4 col-md-4"></div>
                        <div class="col-sm-4 col-md-4">
                            <input class="btn btn-primary" type="submit" value="我要预约">
                        </div>
                        <div class="col-sm-4 col-md-4"></div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<footer class="main-footer">
    <div class="container">
        <div class="row">
            <div class="col-sm-4">
                <div class="widget">
                    <h4 class="title">最新文章</h4>
                    <div class="content recent-post"></div>
                </div>
            </div>

            <div class="col-sm-4">
                <div class="widget">
                    <h4 class="title">标签云</h4>
                    <div class="content tag-cloud">
                        <a href="/tag/about-ghost/">Ghost</a>
                        <a href="/tag/release/">新版本发布</a>
                        <a href="/tag/javascript/">JavaScript</a>
                        <a href="/tag/promise/">Promise</a>
                        <a href="/tag/zhuti/">主题</a>
                        <a href="/tag/mysql/">MySQL</a>
                        <a href="/tag/nodejs/">Node.js</a>
                        <a href="/tag/ghost-in-depth/">深度玩转 Ghost</a>
                        <a href="/tag/ubuntu/">Ubuntu</a>
                        <a href="/tag/aliyun-ecs/">阿里云服务器</a>
                        <a href="/tag/nginx/">Nginx</a>
                        <a href="/tag/bae/">BAE</a>
                        <a href="/tag/theme/">Theme</a>
                        <a href="/tag/ghost-0-7-ban-ben/">Ghost 0.7 版本</a>
                        <a href="/tag/zhu-shou-han-shu/">助手函数</a>


                        <a href="/tag-cloud/">...</a>
                    </div>
                </div>
            </div>

            <div class="col-sm-4">
                <div class="widget">
                    <h4 class="title">合作伙伴</h4>
                    <div class="content tag-cloud friend-links">
                        <a href="http://www.bootcss.com" title="Bootstrap中文网" onclick="_hmt.push(['_trackEvent', 'link', 'click', 'bootcsscom'])" target="_blank">Bootstrap中文网</a>
                        <a href="http://www.bootcdn.cn" title="开放CDN服务" onclick="_hmt.push(['_trackEvent', 'link', 'click', 'bootcdncn'])" target="_blank">开放CDN服务</a>
                        <a href="http://www.gruntjs.net" title="Grunt中文网" onclick="_hmt.push(['_trackEvent', 'link', 'click', 'gruntjsnet'])" target="_blank">Grunt中文网</a>
                        <hr>
                        <a href="http://www.aliyun.com/" title="阿里云" onclick="_hmt.push(['_trackEvent', 'link', 'click', 'aliyun'])" target="_blank">阿里云</a>
                        <hr>
                        <a href="https://www.upyun.com/" title="又拍云" onclick="_hmt.push(['_trackEvent', 'link', 'click', 'upyun'])" target="_blank">又拍云</a>
                        <a href="http://www.ucloud.cn/" title="UCloud" onclick="_hmt.push(['_trackEvent', 'link', 'click', 'ucloud'])" target="_blank">UCloud</a>
                        <a href="http://www.qiniu.com/" title="七牛云存储" onclick="_hmt.push(['_trackEvent', 'link', 'click', 'qiniu'])" target="_blank">七牛云存储</a>
                    </div>
                </div></div>
        </div>
    </div>
</footer>

<div class="copyright">
    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <span>Copyright &copy; <a href="http://www.ghostchina.com/">广州市民兴村</a></span> |
                <span><a href="http://www.miibeian.gov.cn/" target="_blank">粤ICP备11008151号</a></span> |
                <span>粤公网安备11010802014853</span>
            </div>
        </div>
    </div>
</div>

<a href="#" id="back-to-top"><i class="fa fa-angle-up"></i></a>


<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>