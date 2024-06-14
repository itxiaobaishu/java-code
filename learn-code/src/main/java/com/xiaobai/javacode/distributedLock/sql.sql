DROP TABLE IF EXISTS `locks`;
CREATE TABLE `locks` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`lock_key` varchar(255) NOT NULL COMMENT '需要锁定的资源',
`repeat_key` varchar(255) NOT NULL COMMENT '可重入标识',
`repeat_time` int(11) DEFAULT NULL COMMENT '重入次数',
`update_time` datetime DEFAULT NULL COMMENT '更新时间', PRIMARY KEY (`id`),
UNIQUE KEY `lock_key` (`lock_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;