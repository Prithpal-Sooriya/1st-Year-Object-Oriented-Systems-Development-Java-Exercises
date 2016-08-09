TYPE=VIEW
query=select `team`.`name` AS `Team`,`batting`.`yearID` AS `yearID`,((sum(`batting`.`HR`) + sum(`batting`.`TRPL`)) + sum(`batting`.`DBL`)) AS `ExtraBaseHits` from (`trainwarehouse`.`bb_batting` `batting` join `trainwarehouse`.`teams` `team` on((`team`.`teamID` = `batting`.`teamID`))) where (`batting`.`yearID` > 1926) group by `batting`.`teamID`,`batting`.`yearID` order by ((sum(`batting`.`HR`) + sum(`batting`.`TRPL`)) + sum(`batting`.`DBL`)) desc
md5=1ed051ca6b4caabf8541ccc3e99168fc
updatable=0
algorithm=0
definer_user=root
definer_host=localhost
suid=1
with_check_option=0
timestamp=2012-12-15 22:02:25
create-version=1
source=select \n        `team`.`name` AS `Team`,\n        `batting`.`yearID` AS `yearID`,\n        ((sum(`batting`.`HR`) + sum(`batting`.`TRPL`)) + sum(`batting`.`DBL`)) AS `ExtraBaseHits`\n    from\n        (`trainwarehouse`.`bb_batting` `batting`\n        join `trainwarehouse`.`teams` `team` ON ((`team`.`teamID` = `batting`.`teamID`)))\n    where\n        (`batting`.`yearID` > 1926)\n    group by `batting`.`teamID` , `batting`.`yearID`\n    order by ((sum(`batting`.`HR`) + sum(`batting`.`TRPL`)) + sum(`batting`.`DBL`)) desc
client_cs_name=utf8
connection_cl_name=utf8_general_ci
view_body_utf8=select `team`.`name` AS `Team`,`batting`.`yearID` AS `yearID`,((sum(`batting`.`HR`) + sum(`batting`.`TRPL`)) + sum(`batting`.`DBL`)) AS `ExtraBaseHits` from (`trainwarehouse`.`bb_batting` `batting` join `trainwarehouse`.`teams` `team` on((`team`.`teamID` = `batting`.`teamID`))) where (`batting`.`yearID` > 1926) group by `batting`.`teamID`,`batting`.`yearID` order by ((sum(`batting`.`HR`) + sum(`batting`.`TRPL`)) + sum(`batting`.`DBL`)) desc
