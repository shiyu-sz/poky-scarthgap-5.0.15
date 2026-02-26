SUMMARY = "Customed out-of-tree module."
DESCRIPTION = "${SUMMARY}"
LICENSE = "CLOSED"
inherit module
SRC_URI = "file://Makefile \
    file://customer.c \
    file://COPYING \
    "
S = "${WORKDIR}"
RPROVIDES:${PN} += "kernel-module-customer"