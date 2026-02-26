#include <linux/module.h>

static int __init customer_init(void)
{
    pr_info("customer.ko(out-of-tree module) loading succefully.\n");
    return 0;
}

static void __exit customer_exit(void)
{
    pr_info("customer.ko(out-of-tree module) unloaded succefully.\n");
}

module_init(customer_init);
module_exit(customer_exit);
MODULE_LICENSE("GPL");