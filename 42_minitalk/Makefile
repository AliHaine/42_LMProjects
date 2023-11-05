# **************************************************************************** #
#                                                                              #
#                                                         :::      ::::::::    #
#    Makefile                                           :+:      :+:    :+:    #
#                                                     +:+ +:+         +:+      #
#    By: ayagmur <marvin@42.fr>                     +#+  +:+       +#+         #
#                                                 +#+#+#+#+#+   +#+            #
#    Created: 2022/11/04 13:50:30 by ayagmur           #+#    #+#              #
#    Updated: 2022/12/15 17:59:50 by ayagmur          ###   ########.fr        #
#                                                                              #
# **************************************************************************** #

CNAME = client
SNAME = server
CNAME_BONUS = client_bonus
SNAME_BONUS = server_bonus
CC = gcc
CFLAGS = -Wall -Werror -Wextra
CSRCS =	minitalk_client.c \
		ft_printf/ft_printf.c \
		ft_printf/lib/ft_putstr.c \
		ft_printf/lib/ft_putchar.c \
		ft_printf/lib/ft_strlen.c \
		ft_printf/srcs/ft_itoa.c \
		ft_printf/srcs/ft_itoa_unsigned.c \
		ft_printf/srcs/isconvchar.c \
		ft_printf/srcs/type_manager.c \
		ft_printf/srcs/convert_to_basesix.c \
		lib/ft_atoi.c

CSRCS_BONUS =	minitalk_client_bonus.c \
				ft_printf/ft_printf.c \
				ft_printf/lib/ft_putstr.c \
				ft_printf/lib/ft_putchar.c \
				ft_printf/lib/ft_strlen.c \
				ft_printf/srcs/ft_itoa.c \
				ft_printf/srcs/ft_itoa_unsigned.c \
				ft_printf/srcs/isconvchar.c \
				ft_printf/srcs/type_manager.c \
				ft_printf/srcs/convert_to_basesix.c \
				lib/ft_atoi.c

SSRCS =	minitalk_serv.c \
		ft_printf/ft_printf.c \
		ft_printf/lib/ft_putstr.c \
		ft_printf/lib/ft_putchar.c \
		ft_printf/lib/ft_strlen.c \
		ft_printf/srcs/ft_itoa.c \
		ft_printf/srcs/ft_itoa_unsigned.c \
		ft_printf/srcs/isconvchar.c \
		ft_printf/srcs/type_manager.c \
		ft_printf/srcs/convert_to_basesix.c \
		lib/ft_atoi.c

SSRCS_BONUS =	minitalk_serv_bonus.c \
				ft_printf/ft_printf.c \
				ft_printf/lib/ft_putstr.c \
				ft_printf/lib/ft_putchar.c \
				ft_printf/lib/ft_strlen.c \
				ft_printf/srcs/ft_itoa.c \
				ft_printf/srcs/ft_itoa_unsigned.c \
				ft_printf/srcs/isconvchar.c \
				ft_printf/srcs/type_manager.c \
				ft_printf/srcs/convert_to_basesix.c \
				lib/ft_atoi.c

COBJS = ${CSRCS:.c=.o}
SOBJS = $(SSRCS:.c=.o)
COBJS_BONUS = ${CSRCS_BONUS:.c=.o}
SOBJS_BONUS = $(SSRCS_BONUS:.c=.o)

.c.o:
	${CC} ${CFLAGS} -g -c $< -o ${<:.c=.o}

all: $(CNAME) $(SNAME)

$(CNAME): $(COBJS)
	$(CC) $(CFLAGS) -o $(CNAME) $(COBJS)

$(SNAME): $(SOBJS)
	$(CC) $(CFLAGS) -o $(SNAME) $(SOBJS)

bonus: $(CNAME_BONUS) $(SNAME_BONUS)

$(CNAME_BONUS): $(COBJS_BONUS)
	$(CC) $(CFLAGS) -o $(CNAME_BONUS) $(COBJS_BONUS)

$(SNAME_BONUS): $(SOBJS_BONUS)
	$(CC) $(CFLAGS) -o $(SNAME_BONUS) $(SOBJS_BONUS)

clean:
	rm -rf $(COBJS) $(SOBJS) $(COBJS_BONUS) $(SOBJS_BONUS)

fclean: clean
	rm -rf $(CNAME) $(SNAME) $(CNAME_BONUS) $(SNAME_BONUS)

re: fclean all

.PHONY: all clean fclean
