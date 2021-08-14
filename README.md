# SmsForwarder (短信转发器) 



本项目由[pppscn/SmsForwarder](https://github.com/pppscn/SmsForwarder)修改而来。
在此表示衷心的感谢！



相较于源项目，增加或优化了以下功能：

1. 来电转接(转发规则与短信相同)；
2. 添加电池优化设置入口；
3. 手机重启后，主动初始化设置。（解决部分情况下，手机重启后无法转发，必须打开app问题）



移除了在线更新和友盟相关组件（强迫症患者，转发短信这种敏感信息，不喜第三方组件）。

release包由github action自动编译，可放心食用。
