
    create table `addresses` (
       `id` bigint not null auto_increment,
        `address` `TEXT` not null,
        `phone` varchar(255) not null,
        `recipient_name` varchar(255) not null,
        `customer_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `customers` (
       `id` bigint not null auto_increment,
        `address` `TEXT`,
        `email` varchar(255),
        `identity` varchar(255),
        `name` varchar(255) not null,
        `password` varchar(255) not null,
        `phone` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `order_items` (
       `id` bigint not null auto_increment,
        `price` decimal(10,2) not null,
        `quantity` integer not null,
        `order_id` bigint not null,
        `product_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `orders` (
       `id` bigint not null auto_increment,
        `address_id` bigint,
        `note` `TEXT`,
        `order_date` datetime(6),
        `status` varchar(255) not null,
        `total_amount` decimal(10,2) not null,
        `customer_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `products` (
       `id` bigint not null auto_increment,
        `description` `TEXT`,
        `image_url` varchar(255),
        `name` varchar(255) not null,
        `price` decimal(10,2) not null,
        `status` varchar(255) not null,
        `stock` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    alter table `customers` 
       add constraint UK_rfbvkrffamfql7cjmen8v976v unique (`email`);

    alter table `addresses` 
       add constraint `FK69hjetpplponebs73eqw6u8tg` 
       foreign key (`customer_id`) 
       references `customers` (`id`);

    alter table `order_items` 
       add constraint `FK6gg8woymk43fp55jtjlgkd1eh` 
       foreign key (`order_id`) 
       references `orders` (`id`);

    alter table `order_items` 
       add constraint `FKsjxs5u3kcg428neygham498rn` 
       foreign key (`product_id`) 
       references `products` (`id`);

    alter table `orders` 
       add constraint FK_ORDER_CUSTOMER 
       foreign key (`customer_id`) 
       references `customers` (`id`);

    create table `addresses` (
       `id` bigint not null auto_increment,
        `address` `TEXT` not null,
        `phone` varchar(255) not null,
        `recipient_name` varchar(255) not null,
        `customer_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `customers` (
       `id` bigint not null auto_increment,
        `address` `TEXT`,
        `email` varchar(255),
        `identity` varchar(255),
        `name` varchar(255) not null,
        `password` varchar(255) not null,
        `phone` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `order_items` (
       `id` bigint not null auto_increment,
        `price` decimal(10,2) not null,
        `quantity` integer not null,
        `order_id` bigint not null,
        `product_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `orders` (
       `id` bigint not null auto_increment,
        `address_id` bigint,
        `note` `TEXT`,
        `order_date` datetime(6),
        `status` varchar(255) not null,
        `total_amount` decimal(10,2) not null,
        `customer_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `products` (
       `id` bigint not null auto_increment,
        `description` `TEXT`,
        `image_url` varchar(255),
        `name` varchar(255) not null,
        `price` decimal(10,2) not null,
        `status` varchar(255) not null,
        `stock` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    alter table `customers` 
       add constraint UK_rfbvkrffamfql7cjmen8v976v unique (`email`);

    alter table `addresses` 
       add constraint `FK69hjetpplponebs73eqw6u8tg` 
       foreign key (`customer_id`) 
       references `customers` (`id`);

    alter table `order_items` 
       add constraint `FK6gg8woymk43fp55jtjlgkd1eh` 
       foreign key (`order_id`) 
       references `orders` (`id`);

    alter table `order_items` 
       add constraint `FKsjxs5u3kcg428neygham498rn` 
       foreign key (`product_id`) 
       references `products` (`id`);

    alter table `orders` 
       add constraint FK_ORDER_CUSTOMER 
       foreign key (`customer_id`) 
       references `customers` (`id`);

    create table `addresses` (
       `id` bigint not null auto_increment,
        `address` `TEXT` not null,
        `phone` varchar(255) not null,
        `recipient_name` varchar(255) not null,
        `customer_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `customers` (
       `id` bigint not null auto_increment,
        `address` `TEXT`,
        `email` varchar(255),
        `identity` varchar(255),
        `name` varchar(255) not null,
        `password` varchar(255) not null,
        `phone` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `order_items` (
       `id` bigint not null auto_increment,
        `price` decimal(10,2) not null,
        `quantity` integer not null,
        `order_id` bigint not null,
        `product_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `orders` (
       `id` bigint not null auto_increment,
        `address_id` bigint,
        `note` `TEXT`,
        `order_date` datetime(6),
        `status` varchar(255) not null,
        `total_amount` decimal(10,2) not null,
        `customer_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `products` (
       `id` bigint not null auto_increment,
        `description` `TEXT`,
        `image_url` varchar(255),
        `name` varchar(255) not null,
        `price` decimal(10,2) not null,
        `status` varchar(255) not null,
        `stock` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    alter table `customers` 
       add constraint UK_rfbvkrffamfql7cjmen8v976v unique (`email`);

    alter table `addresses` 
       add constraint `FK69hjetpplponebs73eqw6u8tg` 
       foreign key (`customer_id`) 
       references `customers` (`id`);

    alter table `order_items` 
       add constraint `FK6gg8woymk43fp55jtjlgkd1eh` 
       foreign key (`order_id`) 
       references `orders` (`id`);

    alter table `order_items` 
       add constraint `FKsjxs5u3kcg428neygham498rn` 
       foreign key (`product_id`) 
       references `products` (`id`);

    alter table `orders` 
       add constraint FK_ORDER_CUSTOMER 
       foreign key (`customer_id`) 
       references `customers` (`id`);

    create table `addresses` (
       `id` bigint not null auto_increment,
        `address` `TEXT` not null,
        `phone` varchar(255) not null,
        `recipient_name` varchar(255) not null,
        `customer_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `customers` (
       `id` bigint not null auto_increment,
        `address` `TEXT`,
        `email` varchar(255),
        `identity` varchar(255),
        `name` varchar(255) not null,
        `password` varchar(255) not null,
        `phone` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `order_items` (
       `id` bigint not null auto_increment,
        `price` decimal(10,2) not null,
        `quantity` integer not null,
        `order_id` bigint not null,
        `product_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `orders` (
       `id` bigint not null auto_increment,
        `address_id` bigint,
        `note` `TEXT`,
        `order_date` datetime(6),
        `status` varchar(255) not null,
        `total_amount` decimal(10,2) not null,
        `customer_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `products` (
       `id` bigint not null auto_increment,
        `description` `TEXT`,
        `image_url` varchar(255),
        `name` varchar(255) not null,
        `price` decimal(10,2) not null,
        `status` varchar(255) not null,
        `stock` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    alter table `customers` 
       add constraint UK_rfbvkrffamfql7cjmen8v976v unique (`email`);

    alter table `addresses` 
       add constraint `FK69hjetpplponebs73eqw6u8tg` 
       foreign key (`customer_id`) 
       references `customers` (`id`);

    alter table `order_items` 
       add constraint `FK6gg8woymk43fp55jtjlgkd1eh` 
       foreign key (`order_id`) 
       references `orders` (`id`);

    alter table `order_items` 
       add constraint `FKsjxs5u3kcg428neygham498rn` 
       foreign key (`product_id`) 
       references `products` (`id`);

    alter table `orders` 
       add constraint FK_ORDER_CUSTOMER 
       foreign key (`customer_id`) 
       references `customers` (`id`);

    create table `addresses` (
       `id` bigint not null auto_increment,
        `address` `TEXT` not null,
        `phone` varchar(255) not null,
        `recipient_name` varchar(255) not null,
        `customer_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `customers` (
       `id` bigint not null auto_increment,
        `address` `TEXT`,
        `email` varchar(255),
        `identity` varchar(255),
        `name` varchar(255) not null,
        `password` varchar(255) not null,
        `phone` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `order_items` (
       `id` bigint not null auto_increment,
        `price` decimal(10,2) not null,
        `quantity` integer not null,
        `order_id` bigint not null,
        `product_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `orders` (
       `id` bigint not null auto_increment,
        `address_id` bigint,
        `note` `TEXT`,
        `order_date` datetime(6),
        `status` varchar(255) not null,
        `total_amount` decimal(10,2) not null,
        `customer_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `products` (
       `id` bigint not null auto_increment,
        `description` `TEXT`,
        `image_url` varchar(255),
        `name` varchar(255) not null,
        `price` decimal(10,2) not null,
        `status` varchar(255) not null,
        `stock` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    alter table `customers` 
       add constraint UK_rfbvkrffamfql7cjmen8v976v unique (`email`);

    alter table `addresses` 
       add constraint `FK69hjetpplponebs73eqw6u8tg` 
       foreign key (`customer_id`) 
       references `customers` (`id`);

    alter table `order_items` 
       add constraint `FK6gg8woymk43fp55jtjlgkd1eh` 
       foreign key (`order_id`) 
       references `orders` (`id`);

    alter table `order_items` 
       add constraint `FKsjxs5u3kcg428neygham498rn` 
       foreign key (`product_id`) 
       references `products` (`id`);

    alter table `orders` 
       add constraint FK_ORDER_CUSTOMER 
       foreign key (`customer_id`) 
       references `customers` (`id`);

    create table `addresses` (
       `id` bigint not null auto_increment,
        `address` `TEXT` not null,
        `phone` varchar(255) not null,
        `recipient_name` varchar(255) not null,
        `customer_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `customers` (
       `id` bigint not null auto_increment,
        `address` `TEXT`,
        `email` varchar(255),
        `identity` varchar(255),
        `name` varchar(255) not null,
        `password` varchar(255) not null,
        `phone` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `order_items` (
       `id` bigint not null auto_increment,
        `price` decimal(10,2) not null,
        `quantity` integer not null,
        `order_id` bigint not null,
        `product_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `orders` (
       `id` bigint not null auto_increment,
        `address_id` bigint,
        `note` `TEXT`,
        `order_date` datetime(6),
        `status` varchar(255) not null,
        `total_amount` decimal(10,2) not null,
        `customer_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `products` (
       `id` bigint not null auto_increment,
        `description` `TEXT`,
        `image_url` varchar(255),
        `name` varchar(255) not null,
        `price` decimal(10,2) not null,
        `status` varchar(255) not null,
        `stock` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    alter table `customers` 
       add constraint UK_rfbvkrffamfql7cjmen8v976v unique (`email`);

    alter table `addresses` 
       add constraint `FK69hjetpplponebs73eqw6u8tg` 
       foreign key (`customer_id`) 
       references `customers` (`id`);

    alter table `order_items` 
       add constraint `FK6gg8woymk43fp55jtjlgkd1eh` 
       foreign key (`order_id`) 
       references `orders` (`id`);

    alter table `order_items` 
       add constraint `FKsjxs5u3kcg428neygham498rn` 
       foreign key (`product_id`) 
       references `products` (`id`);

    alter table `orders` 
       add constraint FK_ORDER_CUSTOMER 
       foreign key (`customer_id`) 
       references `customers` (`id`);

    create table `addresses` (
       `id` bigint not null auto_increment,
        `address` `TEXT` not null,
        `phone` varchar(255) not null,
        `recipient_name` varchar(255) not null,
        `customer_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `customers` (
       `id` bigint not null auto_increment,
        `address` `TEXT`,
        `email` varchar(255),
        `identity` varchar(255),
        `name` varchar(255) not null,
        `password` varchar(255) not null,
        `phone` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `order_items` (
       `id` bigint not null auto_increment,
        `price` decimal(10,2) not null,
        `quantity` integer not null,
        `order_id` bigint not null,
        `product_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `orders` (
       `id` bigint not null auto_increment,
        `address_id` bigint,
        `note` `TEXT`,
        `order_date` datetime(6),
        `status` varchar(255) not null,
        `total_amount` decimal(10,2) not null,
        `customer_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `products` (
       `id` bigint not null auto_increment,
        `description` `TEXT`,
        `image_url` varchar(255),
        `name` varchar(255) not null,
        `price` decimal(10,2) not null,
        `status` varchar(255) not null,
        `stock` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    alter table `customers` 
       add constraint UK_rfbvkrffamfql7cjmen8v976v unique (`email`);

    alter table `addresses` 
       add constraint `FK69hjetpplponebs73eqw6u8tg` 
       foreign key (`customer_id`) 
       references `customers` (`id`);

    alter table `order_items` 
       add constraint `FK6gg8woymk43fp55jtjlgkd1eh` 
       foreign key (`order_id`) 
       references `orders` (`id`);

    alter table `order_items` 
       add constraint `FKsjxs5u3kcg428neygham498rn` 
       foreign key (`product_id`) 
       references `products` (`id`);

    alter table `orders` 
       add constraint FK_ORDER_CUSTOMER 
       foreign key (`customer_id`) 
       references `customers` (`id`);

    create table `addresses` (
       `id` bigint not null auto_increment,
        `address` `TEXT` not null,
        `phone` varchar(255) not null,
        `recipient_name` varchar(255) not null,
        `customer_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `customers` (
       `id` bigint not null auto_increment,
        `address` `TEXT`,
        `email` varchar(255),
        `identity` varchar(255),
        `name` varchar(255) not null,
        `password` varchar(255) not null,
        `phone` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `order_items` (
       `id` bigint not null auto_increment,
        `price` decimal(10,2) not null,
        `quantity` integer not null,
        `order_id` bigint not null,
        `product_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `orders` (
       `id` bigint not null auto_increment,
        `address_id` bigint,
        `note` `TEXT`,
        `order_date` datetime(6),
        `status` varchar(255) not null,
        `total_amount` decimal(10,2) not null,
        `customer_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `products` (
       `id` bigint not null auto_increment,
        `description` `TEXT`,
        `image_url` varchar(255),
        `name` varchar(255) not null,
        `price` decimal(10,2) not null,
        `status` varchar(255) not null,
        `stock` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    alter table `customers` 
       add constraint UK_rfbvkrffamfql7cjmen8v976v unique (`email`);

    alter table `addresses` 
       add constraint `FK69hjetpplponebs73eqw6u8tg` 
       foreign key (`customer_id`) 
       references `customers` (`id`);

    alter table `order_items` 
       add constraint `FK6gg8woymk43fp55jtjlgkd1eh` 
       foreign key (`order_id`) 
       references `orders` (`id`);

    alter table `order_items` 
       add constraint `FKsjxs5u3kcg428neygham498rn` 
       foreign key (`product_id`) 
       references `products` (`id`);

    alter table `orders` 
       add constraint FK_ORDER_CUSTOMER 
       foreign key (`customer_id`) 
       references `customers` (`id`);

    create table `addresses` (
       `id` bigint not null auto_increment,
        `address` `TEXT` not null,
        `phone` varchar(255) not null,
        `recipient_name` varchar(255) not null,
        `customer_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `customers` (
       `id` bigint not null auto_increment,
        `address` `TEXT`,
        `email` varchar(255),
        `identity` varchar(255),
        `name` varchar(255) not null,
        `password` varchar(255) not null,
        `phone` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `order_items` (
       `id` bigint not null auto_increment,
        `price` decimal(10,2) not null,
        `quantity` integer not null,
        `order_id` bigint not null,
        `product_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `orders` (
       `id` bigint not null auto_increment,
        `address_id` bigint,
        `note` `TEXT`,
        `order_date` datetime(6),
        `status` varchar(255) not null,
        `total_amount` decimal(10,2) not null,
        `customer_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `products` (
       `id` bigint not null auto_increment,
        `description` `TEXT`,
        `image_url` varchar(255),
        `name` varchar(255) not null,
        `price` decimal(10,2) not null,
        `status` varchar(255) not null,
        `stock` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    alter table `customers` 
       add constraint UK_rfbvkrffamfql7cjmen8v976v unique (`email`);

    alter table `addresses` 
       add constraint `FK69hjetpplponebs73eqw6u8tg` 
       foreign key (`customer_id`) 
       references `customers` (`id`);

    alter table `order_items` 
       add constraint `FK6gg8woymk43fp55jtjlgkd1eh` 
       foreign key (`order_id`) 
       references `orders` (`id`);

    alter table `order_items` 
       add constraint `FKsjxs5u3kcg428neygham498rn` 
       foreign key (`product_id`) 
       references `products` (`id`);

    alter table `orders` 
       add constraint FK_ORDER_CUSTOMER 
       foreign key (`customer_id`) 
       references `customers` (`id`);

    create table `addresses` (
       `id` bigint not null auto_increment,
        `address` `TEXT` not null,
        `phone` varchar(255) not null,
        `recipient_name` varchar(255) not null,
        `customer_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `customers` (
       `id` bigint not null auto_increment,
        `address` `TEXT`,
        `email` varchar(255),
        `identity` varchar(255),
        `name` varchar(255) not null,
        `password` varchar(255) not null,
        `phone` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `order_items` (
       `id` bigint not null auto_increment,
        `price` decimal(10,2) not null,
        `quantity` integer not null,
        `order_id` bigint not null,
        `product_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `orders` (
       `id` bigint not null auto_increment,
        `address_id` bigint,
        `note` `TEXT`,
        `order_date` datetime(6),
        `status` varchar(255) not null,
        `total_amount` decimal(10,2) not null,
        `customer_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `products` (
       `id` bigint not null auto_increment,
        `description` `TEXT`,
        `image_url` varchar(255),
        `name` varchar(255) not null,
        `price` decimal(10,2) not null,
        `status` varchar(255) not null,
        `stock` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    alter table `customers` 
       add constraint UK_rfbvkrffamfql7cjmen8v976v unique (`email`);

    alter table `addresses` 
       add constraint `FK69hjetpplponebs73eqw6u8tg` 
       foreign key (`customer_id`) 
       references `customers` (`id`);

    alter table `order_items` 
       add constraint `FK6gg8woymk43fp55jtjlgkd1eh` 
       foreign key (`order_id`) 
       references `orders` (`id`);

    alter table `order_items` 
       add constraint `FKsjxs5u3kcg428neygham498rn` 
       foreign key (`product_id`) 
       references `products` (`id`);

    alter table `orders` 
       add constraint FK_ORDER_CUSTOMER 
       foreign key (`customer_id`) 
       references `customers` (`id`);

    create table `addresses` (
       `id` bigint not null auto_increment,
        `address` `TEXT` not null,
        `phone` varchar(255) not null,
        `recipient_name` varchar(255) not null,
        `customer_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `customers` (
       `id` bigint not null auto_increment,
        `address` `TEXT`,
        `email` varchar(255),
        `identity` varchar(255),
        `name` varchar(255) not null,
        `password` varchar(255) not null,
        `phone` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `order_items` (
       `id` bigint not null auto_increment,
        `price` decimal(10,2) not null,
        `quantity` integer not null,
        `order_id` bigint not null,
        `product_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `orders` (
       `id` bigint not null auto_increment,
        `address_id` bigint,
        `note` `TEXT`,
        `order_date` datetime(6),
        `status` varchar(255) not null,
        `total_amount` decimal(10,2) not null,
        `customer_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `products` (
       `id` bigint not null auto_increment,
        `description` `TEXT`,
        `image_url` varchar(255),
        `name` varchar(255) not null,
        `price` decimal(10,2) not null,
        `status` varchar(255) not null,
        `stock` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    alter table `customers` 
       add constraint UK_rfbvkrffamfql7cjmen8v976v unique (`email`);

    alter table `addresses` 
       add constraint `FK69hjetpplponebs73eqw6u8tg` 
       foreign key (`customer_id`) 
       references `customers` (`id`);

    alter table `order_items` 
       add constraint `FK6gg8woymk43fp55jtjlgkd1eh` 
       foreign key (`order_id`) 
       references `orders` (`id`);

    alter table `order_items` 
       add constraint `FKsjxs5u3kcg428neygham498rn` 
       foreign key (`product_id`) 
       references `products` (`id`);

    alter table `orders` 
       add constraint FK_ORDER_CUSTOMER 
       foreign key (`customer_id`) 
       references `customers` (`id`);

    create table `addresses` (
       `id` bigint not null auto_increment,
        `address` `TEXT` not null,
        `phone` varchar(255) not null,
        `recipient_name` varchar(255) not null,
        `customer_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `customers` (
       `id` bigint not null auto_increment,
        `address` `TEXT`,
        `email` varchar(255),
        `identity` varchar(255),
        `name` varchar(255) not null,
        `password` varchar(255) not null,
        `phone` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `order_items` (
       `id` bigint not null auto_increment,
        `price` decimal(10,2) not null,
        `quantity` integer not null,
        `order_id` bigint not null,
        `product_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `orders` (
       `id` bigint not null auto_increment,
        `address_id` bigint,
        `note` `TEXT`,
        `order_date` datetime(6),
        `status` varchar(255) not null,
        `total_amount` decimal(10,2) not null,
        `customer_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `products` (
       `id` bigint not null auto_increment,
        `description` `TEXT`,
        `image_url` varchar(255),
        `name` varchar(255) not null,
        `price` decimal(10,2) not null,
        `status` varchar(255) not null,
        `stock` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    alter table `customers` 
       add constraint UK_rfbvkrffamfql7cjmen8v976v unique (`email`);

    alter table `addresses` 
       add constraint `FK69hjetpplponebs73eqw6u8tg` 
       foreign key (`customer_id`) 
       references `customers` (`id`);

    alter table `order_items` 
       add constraint `FK6gg8woymk43fp55jtjlgkd1eh` 
       foreign key (`order_id`) 
       references `orders` (`id`);

    alter table `order_items` 
       add constraint `FKsjxs5u3kcg428neygham498rn` 
       foreign key (`product_id`) 
       references `products` (`id`);

    alter table `orders` 
       add constraint FK_ORDER_CUSTOMER 
       foreign key (`customer_id`) 
       references `customers` (`id`);

    create table `addresses` (
       `id` bigint not null auto_increment,
        `address` `TEXT` not null,
        `phone` varchar(255) not null,
        `recipient_name` varchar(255) not null,
        `customer_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `customers` (
       `id` bigint not null auto_increment,
        `address` `TEXT`,
        `email` varchar(255),
        `identity` varchar(255),
        `name` varchar(255) not null,
        `password` varchar(255) not null,
        `phone` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `order_items` (
       `id` bigint not null auto_increment,
        `price` decimal(10,2) not null,
        `quantity` integer not null,
        `order_id` bigint not null,
        `product_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `orders` (
       `id` bigint not null auto_increment,
        `address_id` bigint,
        `note` `TEXT`,
        `order_date` datetime(6),
        `status` varchar(255) not null,
        `total_amount` decimal(10,2) not null,
        `customer_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `products` (
       `id` bigint not null auto_increment,
        `description` `TEXT`,
        `image_url` varchar(255),
        `name` varchar(255) not null,
        `price` decimal(10,2) not null,
        `status` varchar(255) not null,
        `stock` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    alter table `customers` 
       add constraint UK_rfbvkrffamfql7cjmen8v976v unique (`email`);

    alter table `addresses` 
       add constraint `FK69hjetpplponebs73eqw6u8tg` 
       foreign key (`customer_id`) 
       references `customers` (`id`);

    alter table `order_items` 
       add constraint `FK6gg8woymk43fp55jtjlgkd1eh` 
       foreign key (`order_id`) 
       references `orders` (`id`);

    alter table `order_items` 
       add constraint `FKsjxs5u3kcg428neygham498rn` 
       foreign key (`product_id`) 
       references `products` (`id`);

    alter table `orders` 
       add constraint FK_ORDER_CUSTOMER 
       foreign key (`customer_id`) 
       references `customers` (`id`);

    create table `addresses` (
       `id` bigint not null auto_increment,
        `address` `TEXT` not null,
        `phone` varchar(255) not null,
        `recipient_name` varchar(255) not null,
        `customer_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `customers` (
       `id` bigint not null auto_increment,
        `address` `TEXT`,
        `email` varchar(255),
        `identity` varchar(255),
        `name` varchar(255) not null,
        `password` varchar(255) not null,
        `phone` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `order_items` (
       `id` bigint not null auto_increment,
        `price` decimal(10,2) not null,
        `quantity` integer not null,
        `order_id` bigint not null,
        `product_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `orders` (
       `id` bigint not null auto_increment,
        `address_id` bigint,
        `note` `TEXT`,
        `order_date` datetime(6),
        `status` varchar(255) not null,
        `total_amount` decimal(10,2) not null,
        `customer_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `products` (
       `id` bigint not null auto_increment,
        `description` `TEXT`,
        `image_url` varchar(255),
        `name` varchar(255) not null,
        `price` decimal(10,2) not null,
        `status` varchar(255) not null,
        `stock` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    alter table `customers` 
       add constraint UK_rfbvkrffamfql7cjmen8v976v unique (`email`);

    alter table `addresses` 
       add constraint `FK69hjetpplponebs73eqw6u8tg` 
       foreign key (`customer_id`) 
       references `customers` (`id`);

    alter table `order_items` 
       add constraint `FK6gg8woymk43fp55jtjlgkd1eh` 
       foreign key (`order_id`) 
       references `orders` (`id`);

    alter table `order_items` 
       add constraint `FKsjxs5u3kcg428neygham498rn` 
       foreign key (`product_id`) 
       references `products` (`id`);

    alter table `orders` 
       add constraint FK_ORDER_CUSTOMER 
       foreign key (`customer_id`) 
       references `customers` (`id`);

    create table `addresses` (
       `id` bigint not null auto_increment,
        `address` `TEXT` not null,
        `phone` varchar(255) not null,
        `recipient_name` varchar(255) not null,
        `customer_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `customers` (
       `id` bigint not null auto_increment,
        `address` `TEXT`,
        `email` varchar(255),
        `identity` varchar(255),
        `name` varchar(255) not null,
        `password` varchar(255) not null,
        `phone` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `order_items` (
       `id` bigint not null auto_increment,
        `price` decimal(10,2) not null,
        `quantity` integer not null,
        `order_id` bigint not null,
        `product_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `orders` (
       `id` bigint not null auto_increment,
        `address_id` bigint,
        `note` `TEXT`,
        `order_date` datetime(6),
        `status` varchar(255) not null,
        `total_amount` decimal(10,2) not null,
        `customer_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `products` (
       `id` bigint not null auto_increment,
        `description` `TEXT`,
        `image_url` varchar(255),
        `name` varchar(255) not null,
        `price` decimal(10,2) not null,
        `status` varchar(255) not null,
        `stock` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    alter table `customers` 
       add constraint UK_rfbvkrffamfql7cjmen8v976v unique (`email`);

    alter table `addresses` 
       add constraint `FK69hjetpplponebs73eqw6u8tg` 
       foreign key (`customer_id`) 
       references `customers` (`id`);

    alter table `order_items` 
       add constraint `FK6gg8woymk43fp55jtjlgkd1eh` 
       foreign key (`order_id`) 
       references `orders` (`id`);

    alter table `order_items` 
       add constraint `FKsjxs5u3kcg428neygham498rn` 
       foreign key (`product_id`) 
       references `products` (`id`);

    alter table `orders` 
       add constraint FK_ORDER_CUSTOMER 
       foreign key (`customer_id`) 
       references `customers` (`id`);

    create table `addresses` (
       `id` bigint not null auto_increment,
        `address` `TEXT` not null,
        `phone` varchar(255) not null,
        `recipient_name` varchar(255) not null,
        `customer_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `customers` (
       `id` bigint not null auto_increment,
        `address` `TEXT`,
        `email` varchar(255),
        `identity` varchar(255),
        `name` varchar(255) not null,
        `password` varchar(255) not null,
        `phone` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `order_items` (
       `id` bigint not null auto_increment,
        `price` decimal(10,2) not null,
        `quantity` integer not null,
        `order_id` bigint not null,
        `product_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `orders` (
       `id` bigint not null auto_increment,
        `address_id` bigint,
        `note` `TEXT`,
        `order_date` datetime(6),
        `status` varchar(255) not null,
        `total_amount` decimal(10,2) not null,
        `customer_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `products` (
       `id` bigint not null auto_increment,
        `description` `TEXT`,
        `image_url` varchar(255),
        `name` varchar(255) not null,
        `price` decimal(10,2) not null,
        `status` varchar(255) not null,
        `stock` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    alter table `customers` 
       add constraint UK_rfbvkrffamfql7cjmen8v976v unique (`email`);

    alter table `addresses` 
       add constraint `FK69hjetpplponebs73eqw6u8tg` 
       foreign key (`customer_id`) 
       references `customers` (`id`);

    alter table `order_items` 
       add constraint `FK6gg8woymk43fp55jtjlgkd1eh` 
       foreign key (`order_id`) 
       references `orders` (`id`);

    alter table `order_items` 
       add constraint `FKsjxs5u3kcg428neygham498rn` 
       foreign key (`product_id`) 
       references `products` (`id`);

    alter table `orders` 
       add constraint FK_ORDER_CUSTOMER 
       foreign key (`customer_id`) 
       references `customers` (`id`);

    create table `addresses` (
       `id` bigint not null auto_increment,
        `address` `TEXT` not null,
        `phone` varchar(255) not null,
        `recipient_name` varchar(255) not null,
        `customer_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `customers` (
       `id` bigint not null auto_increment,
        `address` `TEXT`,
        `email` varchar(255),
        `identity` varchar(255),
        `name` varchar(255) not null,
        `password` varchar(255) not null,
        `phone` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `order_items` (
       `id` bigint not null auto_increment,
        `price` decimal(10,2) not null,
        `quantity` integer not null,
        `order_id` bigint not null,
        `product_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `orders` (
       `id` bigint not null auto_increment,
        `address_id` bigint,
        `note` `TEXT`,
        `order_date` datetime(6),
        `status` varchar(255) not null,
        `total_amount` decimal(10,2) not null,
        `customer_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `products` (
       `id` bigint not null auto_increment,
        `description` `TEXT`,
        `image_url` varchar(255),
        `name` varchar(255) not null,
        `price` decimal(10,2) not null,
        `status` varchar(255) not null,
        `stock` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    alter table `customers` 
       add constraint UK_rfbvkrffamfql7cjmen8v976v unique (`email`);

    alter table `addresses` 
       add constraint `FK69hjetpplponebs73eqw6u8tg` 
       foreign key (`customer_id`) 
       references `customers` (`id`);

    alter table `order_items` 
       add constraint `FK6gg8woymk43fp55jtjlgkd1eh` 
       foreign key (`order_id`) 
       references `orders` (`id`);

    alter table `order_items` 
       add constraint `FKsjxs5u3kcg428neygham498rn` 
       foreign key (`product_id`) 
       references `products` (`id`);

    alter table `orders` 
       add constraint FK_ORDER_CUSTOMER 
       foreign key (`customer_id`) 
       references `customers` (`id`);

    create table `addresses` (
       `id` bigint not null auto_increment,
        `address` `TEXT` not null,
        `phone` varchar(255) not null,
        `recipient_name` varchar(255) not null,
        `customer_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `customers` (
       `id` bigint not null auto_increment,
        `address` `TEXT`,
        `email` varchar(255),
        `identity` varchar(255),
        `name` varchar(255) not null,
        `password` varchar(255) not null,
        `phone` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `order_items` (
       `id` bigint not null auto_increment,
        `price` decimal(10,2) not null,
        `quantity` integer not null,
        `order_id` bigint not null,
        `product_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `orders` (
       `id` bigint not null auto_increment,
        `address_id` bigint,
        `note` `TEXT`,
        `order_date` datetime(6),
        `status` varchar(255) not null,
        `total_amount` decimal(10,2) not null,
        `customer_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `products` (
       `id` bigint not null auto_increment,
        `description` `TEXT`,
        `image_url` varchar(255),
        `name` varchar(255) not null,
        `price` decimal(10,2) not null,
        `status` varchar(255) not null,
        `stock` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    alter table `customers` 
       add constraint UK_rfbvkrffamfql7cjmen8v976v unique (`email`);

    alter table `addresses` 
       add constraint `FK69hjetpplponebs73eqw6u8tg` 
       foreign key (`customer_id`) 
       references `customers` (`id`);

    alter table `order_items` 
       add constraint `FK6gg8woymk43fp55jtjlgkd1eh` 
       foreign key (`order_id`) 
       references `orders` (`id`);

    alter table `order_items` 
       add constraint `FKsjxs5u3kcg428neygham498rn` 
       foreign key (`product_id`) 
       references `products` (`id`);

    alter table `orders` 
       add constraint FK_ORDER_CUSTOMER 
       foreign key (`customer_id`) 
       references `customers` (`id`);

    create table `addresses` (
       `id` bigint not null auto_increment,
        `address` `TEXT` not null,
        `phone` varchar(255) not null,
        `recipient_name` varchar(255) not null,
        `customer_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `customers` (
       `id` bigint not null auto_increment,
        `address` `TEXT`,
        `email` varchar(255),
        `identity` varchar(255),
        `name` varchar(255) not null,
        `password` varchar(255) not null,
        `phone` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `order_items` (
       `id` bigint not null auto_increment,
        `price` decimal(10,2) not null,
        `quantity` integer not null,
        `order_id` bigint not null,
        `product_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `orders` (
       `id` bigint not null auto_increment,
        `address_id` bigint,
        `note` `TEXT`,
        `order_date` datetime(6),
        `status` varchar(255) not null,
        `total_amount` decimal(10,2) not null,
        `customer_id` bigint not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `products` (
       `id` bigint not null auto_increment,
        `description` `TEXT`,
        `image_url` varchar(255),
        `name` varchar(255) not null,
        `price` decimal(10,2) not null,
        `status` varchar(255) not null,
        `stock` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    alter table `customers` 
       add constraint UK_rfbvkrffamfql7cjmen8v976v unique (`email`);

    alter table `addresses` 
       add constraint `FK69hjetpplponebs73eqw6u8tg` 
       foreign key (`customer_id`) 
       references `customers` (`id`);

    alter table `order_items` 
       add constraint `FK6gg8woymk43fp55jtjlgkd1eh` 
       foreign key (`order_id`) 
       references `orders` (`id`);

    alter table `order_items` 
       add constraint `FKsjxs5u3kcg428neygham498rn` 
       foreign key (`product_id`) 
       references `products` (`id`);

    alter table `orders` 
       add constraint FK_ORDER_CUSTOMER 
       foreign key (`customer_id`) 
       references `customers` (`id`);
