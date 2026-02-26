obj-m := customer.o
SRC := $(shell pwd)

all:
	$(MAKE) -C $(KERNEL_SRC) M=$(SRC)
	
modules_install:
	$(MAKE) -C $(KERNEL_SRC) M=$(SRC) modules_install