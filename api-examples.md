# API 接口访问示例

## 用户认证接口

### 1. 用户登录

```http
POST /api/auth/login
Content-Type: application/json

{
    "email": "user@example.com",
    "password": "password123"
}
```

响应示例（成功）：
```json
{
    "message": "登录成功",
    "customer": {
        "id": 1,
        "name": "张三",
        "email": "user@example.com",
        "phone": "13800138000",
        "address": "北京市朝阳区"
    }
}
```

响应示例（失败）：
```json
{
    "message": "邮箱或密码错误"
}
```

## 微信扫码登录接口

### 1. 获取登录二维码

```http
GET /api/auth/wechat/qrcode
```

响应示例：
```json
{
    "qrcodeUrl": "https://example.com/qrcode"
}
```

### 2. 查询扫码状态

```http
GET /api/auth/wechat/status?sessionId=123456
```

响应示例：
```json
{
    "status": "WAITING" // 或 "SCANNED", "AUTHORIZED"
}
```

### 3. 确认登录

```http
POST /api/auth/wechat/confirm
Content-Type: application/json

{
    "sessionId": "123456"
}
```

响应示例（成功）：
```json
{
    "message": "登录成功",
    "customer": {
        "id": 1,
        "name": "张三",
        "email": "user@example.com",
        "phone": "13800138000",
        "address": "北京市朝阳区"
    }
}
```

响应示例（失败）：
```json
{
    "message": "登录失败"
}
```

## 产品管理接口

### 1. 获取所有产品

```http
GET /api/products
```

响应示例：
```json
[
    {
        "id": 1,
        "name": "iPhone 14",
        "description": "苹果最新手机",
        "price": 6999.00,
        "stock": 100,
        "imageUrl": "http://example.com/images/iphone14.jpg",
        "status": "AVAILABLE"
    },
    {
        "id": 2,
        "name": "MacBook Pro",
        "description": "专业级笔记本电脑",
        "price": 12999.00,
        "stock": 50,
        "imageUrl": "http://example.com/images/macbook-pro.jpg",
        "status": "AVAILABLE"
    }
]
```

### 2. 创建新产品

```http
POST /api/products
Content-Type: application/json

{
    "name": "iPad Pro",
    "description": "新一代平板电脑",
    "price": 6299.00,
    "stock": 200,
    "imageUrl": "http://example.com/images/ipad-pro.jpg",
    "status": "AVAILABLE"
}
```

响应示例：
```json
{
    "id": 3,
    "name": "iPad Pro",
    "description": "新一代平板电脑",
    "price": 6299.00,
    "stock": 200,
    "imageUrl": "http://example.com/images/ipad-pro.jpg",
    "status": "AVAILABLE"
}
```

### 3. 更新产品信息

```http
PUT /api/products/3
Content-Type: application/json

{
    "name": "iPad Pro 2023",
    "description": "最新款平板电脑",
    "price": 6599.00,
    "stock": 200,
    "imageUrl": "http://example.com/images/ipad-pro-2023.jpg",
    "status": "AVAILABLE"
}
```

响应示例：
```json
{
    "id": 3,
    "name": "iPad Pro 2023",
    "description": "最新款平板电脑",
    "price": 6599.00,
    "stock": 200,
    "imageUrl": "http://example.com/images/ipad-pro-2023.jpg",
    "status": "AVAILABLE"
}
```

### 4. 更新产品库存

```http
PATCH /api/products/3/stock?quantity=180
```

响应状态：200 OK

### 5. 搜索产品

```http
GET /api/products/search?name=iPhone
```

响应示例：
```json
[
    {
        "id": 1,
        "name": "iPhone 14",
        "description": "苹果最新手机",
        "price": 6999.00,
        "stock": 100,
        "imageUrl": "http://example.com/images/iphone14.jpg",
        "status": "AVAILABLE"
    },
    {
        "id": 4,
        "name": "iPhone 13",
        "description": "苹果手机",
        "price": 5999.00,
        "stock": 150,
        "imageUrl": "http://example.com/images/iphone13.jpg",
        "status": "AVAILABLE"
    }
]
```

### 6. 查询低库存产品

```http
GET /api/products/low-stock?threshold=20
```

响应示例：
```json
[
    {
        "id": 5,
        "name": "AirPods Pro",
        "description": "无线耳机",
        "price": 1999.00,
        "stock": 15,
        "imageUrl": "http://example.com/images/airpods-pro.jpg",
        "status": "LOW_STOCK"
    }
]
```

### 7. 删除产品

```http
DELETE /api/products/3
```

响应状态：200 OK

## 订单管理接口

### 1. 查询客户订单

```http
GET /api/orders?customerId=1001
```

响应示例：
```json
{
    "message": "查询成功",
    "orders": [
        {
            "id": 1,
            "orderDate": "2023-11-01T10:30:00",
            "totalAmount": 13998.00,
            "status": "COMPLETED",
            "items": [
                {
                    "product": {
                        "id": 1,
                        "name": "iPhone 14",
                        "imageUrl": "http://example.com/images/iphone14.jpg",
                        "price": 6999.00
                    },
                    "quantity": 2,
                    "price": 6999.00
                }
            ]
        },
        {
            "id": 2,
            "orderDate": "2023-11-15T14:20:00",
            "totalAmount": 6299.00,
            "status": "PROCESSING",
            "items": [
                {
                    "product": {
                        "id": 3,
                        "name": "iPad Pro",
                        "imageUrl": "http://example.com/images/ipad-pro.jpg",
                        "price": 6299.00
                    },
                    "quantity": 1,
                    "price": 6299.00
                }
            ]
        }
    ]
}
```

### 2. 按日期范围查询订单

```http
GET /api/orders?startDate=2023-11-01T00:00:00&endDate=2023-11-30T23:59:59
```

响应示例：
```json
[
    {
        "id": 1,
        "customerId": 1001,
        "orderDate": "2023-11-01T10:30:00",
        "totalAmount": 13998.00,
        "status": "COMPLETED"
    },
    {
        "id": 2,
        "customerId": 1002,
        "orderDate": "2023-11-15T14:20:00",
        "totalAmount": 6299.00,
        "status": "PROCESSING"
    }
]
```

### 3. 创建新订单

```http
POST /api/orders
Content-Type: application/json

{
    "customerId": 1001,
    "items": [
        {
            "productId": 1,
            "quantity": 2
        },
        {
            "productId": 2,
            "quantity": 1
        }
    ]
}
```

响应示例：
```json
{
    "id": 3,
    "customerId": 1001,
    "orderDate": "2023-11-20T15:30:00",
    "totalAmount": 15997.00,
    "status": "PENDING",
    "items": [
        {
            "productId": 1,
            "quantity": 2,
            "price": 6999.00
        },
        {
            "productId": 5,
            "quantity": 1,
            "price": 1999.00
        }
    ]
}
```

### 4. 修改订单状态

```http
PUT /api/orders/3/status
Content-Type: application/json

{
    "status": "SHIPPED"
}
```

响应示例：
```json
{
    "id": 3,
    "customerId": 1001,
    "orderDate": "2023-11-20T15:30:00",
    "totalAmount": 15997.00,
    "status": "SHIPPED",
    "items": [
        {
            "productId": 1,
            "quantity": 2,
            "price": 6999.00
        },
        {
            "productId": 5,
            "quantity": 1,
            "price": 1999.00
        }
    ]
}
```

### 5. 删除订单

```http
DELETE /api/orders/3
```

响应状态：200 OK

### 获取我的订单列表
GET /api/orders/my-orders/1001

{
    "message": "查询成功",
    "orders": [
        {
            "id": 1,
            "orderDate": "2023-11-01T10:30:00",
            "totalAmount": 13998.00,
            "status": "COMPLETED",
            "items": [
                {
                    "product": {
                        "id": 1,
                        "name": "iPhone 14",
                        "imageUrl": "http://example.com/images/iphone14.jpg",
                        "price": 6999.00
                    },
                    "quantity": 2,
                    "price": 6999.00
                }
            ]
        }
    ]
}

## 使用说明

1. 所有请求都需要在URL前加上服务器地址，例如：`http://localhost:8080/api/products`
2. POST和PUT请求需要在请求头中设置 `Content-Type: application/json`
3. 日期格式统一使用ISO 8601标准：`YYYY-MM-DDThh:mm:ss`
4. 所有金额单位均为人民币（CNY）
5. 产品图片URL为完整的HTTP(S)地址
6. 产品状态包括：`AVAILABLE`（可用）、`OUT_OF_STOCK`（缺货）、`DISCONTINUED`（停产）、`LOW_STOCK`（低库存）