# 建数据库
create DATABASE msd;
use msd;

# 建表
DROP TABLE IF EXISTS movie;
CREATE TABLE movie (
  id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  movie_no varchar(20) NOT NULL COMMENT '编码',
  name varchar(32) NOT NULL COMMENT '名称',
  score decimal(13,1) NOT NULL DEFAULT '0.0' COMMENT '评分',
  area int(2) DEFAULT NULL COMMENT '地域类型 1欧美 2日本 3香港 4大陆 5其他',
  date date DEFAULT NULL COMMENT '上映日期',
  introduction varchar(1000) DEFAULT NULL COMMENT '影片介绍',
  remark varchar(100) DEFAULT NULL COMMENT '备注',
  status int(1) NOT NULL DEFAULT '1' COMMENT '启停用状态 1启用 0停用',
  is_delete int(1) NOT NULL DEFAULT '0' COMMENT '删除状态 1已删除 0未删除 ',
  create_time datetime DEFAULT CURRENT_TIMESTAMP COMMENT '生成记录时间',
  update_time datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改记录时间',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='电影信息';

# 插入数据
INSERT INTO movie (movie_no, name, score, area, date, introduction) VALUES
('M2019112501', '深夜食堂', 5.1, 5, '2019-08-30', '在上海一条不起眼的小弄堂里，有一家只在深夜营业的小餐馆，老板是一位50岁左右的大叔，他会为每一个到访的食客做一份只属于他（她）的食物，一碗饭一个故事，一碟菜一段人生，暖心抚慰都市夜归人。大叔随着食堂的夜晚一起经历人来人往，满足食客们的味蕾，也见证了各式人生。而无论夜多深、路多远，大叔还会在食堂里继续倾 听大家的故事。'),
('M2019112502', '哪吒之魔童降世', 8.5, 5, '2019-07-26', '天地灵气孕育出一颗能量巨大的混元珠，元始天尊将混元珠提炼成灵珠和魔丸，灵珠投胎为人，助周伐纣时可堪大用；而魔丸则会诞出魔王，为祸人间。元始天尊启动了天劫咒语，3年后天雷将会降临，摧毁魔丸。太乙受命将灵珠托生于陈塘关李靖家的儿子哪吒身上。然而阴差阳错，灵珠和魔丸竟然被掉包。本应是灵珠英雄的哪吒却成了混世大魔王。调皮捣蛋顽劣不堪的哪吒却徒有一颗做英雄的心。然而面对众人对魔丸的误解和即将来临的天雷的降临，哪吒是否命中注定会立地成魔？他将何去何从？'),
('M2019112503', '我和我的祖国', 8.0, 5, '2019-09-30', '七位导演分别取材新中国成立70周年以来，祖国经历的无数个历史性经典瞬间。讲述普通人与国家之间息息相关密不可分的动人故事。聚焦大时代大事件下，小人物和国家之间，看似遥远实则密切的关联，唤醒全球华人共同回忆。'),
('M2019112504', '少年的你', 8.3, 5, '2019-10-25', '陈念是一名即将参加高考的高三学生，同校女生胡晓蝶的跳楼自杀让她的生活陷入了困顿之中。胡晓蝶死后，陈念遭到了以魏莱为首的三人组的霸凌，魏莱虽然表面上看来是乖巧的优等生，实际上却心思毒辣，胡晓蝶的死和她有着千丝万缕的联系。一次偶然中，陈念邂逅了名为小北的小混混，随着时间的推移，心心相惜的两人之间产生了真挚的感情。小北答应陈念在暗中保护她免受魏莱的欺凌，没想到这一决定引发了一连串的连锁反应。负责调查胡晓蝶死因的警官郑易隐隐察觉到校园里的古怪气氛，可他的调查却屡屡遭到校方的阻挠。');
