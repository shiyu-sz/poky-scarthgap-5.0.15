# --- 变量定义 ---
# 使用 ?= 允许 Yocto 环境变量覆盖这些值
CC ?= gcc
OBJDIR = build/obj
BINDIR = build/bin
TARGET = $(BINDIR)/lvgl_demo

# 源文件定义：添加你自己的 .c 文件
SRCS = main.c \
       mouse_cursor_icon.c

# 自动生成对象文件路径
OBJS = $(SRCS:%.c=$(OBJDIR)/%.o)

# 编译参数
# -DLV_CONF_INCLUDE_SIMPLE 解决 lv_conf.h 路径问题
# -I. 确保能找到当前目录下的 lv_conf.h
CFLAGS += -Wall -O3 -DLV_CONF_INCLUDE_SIMPLE -I.

# 链接参数
# --start-group 和 --end-group 解决库之间的循环依赖
# 必须链接 lvgl, lvgl_demos, 以及数学库 lm 和线程库 lpthread
LDFLAGS += -Wl,--start-group -llvgl -llvgl_demos -lm -lpthread -Wl,--end-group

# --- 编译规则 ---

.PHONY: all clean prep

all: prep $(TARGET)

# 创建必要的文件夹
prep:
	@mkdir -p $(OBJDIR)
	@mkdir -p $(BINDIR)

# 链接目标文件
$(TARGET): $(OBJS)
	$(CC) $(OBJS) -o $@ $(LDFLAGS)
	@echo "Build complete: $@"

# 编译源文件
$(OBJDIR)/%.o: %.c
	$(CC) $(CFLAGS) -c $< -o $@

# 清理
clean:
	rm -rf build/