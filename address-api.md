# 地址管理 API 文档
参数说明：

customerId: 客户ID（路径参数）
响应示例：
{
    "message": "查询成功",
    "addresses": [
        {
            "id": 1,
            "recipientName": "张三",
            "phone": "13800138000",
            "address": "北京市朝阳区xx路xx号"
        },
        {
            "id": 2,
            "recipientName": "李四",
            "phone": "13900139000",
            "address": "北京市海淀区yy路yy号"
        }
    ]
}
2. 新增收货地址
POST /api/addresses
Content-Type: application/json

{
    "customerId": 1001,
    "recipientName": "张三",
    "phone": "13800138000",
    "address": "北京市朝阳区xx路xx号"
}
响应示例：
{
    "message": "创建成功",
    "address": {
        "id": 1,
        "recipientName": "张三",
        "phone": "13800138000",
        "address": "北京市朝阳区xx路xx号"
    }
}
3. 修改收货地址
PUT /api/addresses/{id}
Content-Type: application/json

{
    "recipientName": "张三",
    "phone": "13800138000",
    "address": "北京市朝阳区xx路yy号"
}
响应示例：
{
    "message": "更新成功",
    "address": {
        "id": 1,
        "recipientName": "张三",
        "phone": "13800138000",
        "address": "北京市朝阳区xx路yy号"
    }
}
4. 删除收货地址
DELETE /api/addresses/{id}
响应示例：
{
    "message": "删除成功"
}
错误响应
{
    "message": "错误信息描述"
}
所有接口的错误响应格式：
{
    "message": "错误信息描述"
}
使用说明
所有请求都需要在URL前加上服务器地址，例如：http://localhost:8080/api/addresses
POST和PUT请求需要在请求头中设置 Content-Type: application/json
创建地址时必须提供customerId
更新地址时不能修改所属客户

