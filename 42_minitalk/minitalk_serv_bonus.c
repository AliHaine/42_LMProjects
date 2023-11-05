/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   minitalk_serv_bonus.c                              :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ayagmur <marvin@42.fr>                     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2022/12/16 13:42:42 by ayagmur           #+#    #+#             */
/*   Updated: 2022/12/16 13:42:46 by ayagmur          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include "minitalk_bonus.h"

void	action_handler(int signum, siginfo_t *siginfo, void *s)
{
	static char	c = 0;
	static int	i = 7;
	int			clientpid;

	(void)siginfo;
	(void)s;
	clientpid = siginfo->si_pid;
	if (signum == SIGUSR1)
	{
		c |= 1 << i;
	}
	i--;
	if (i < 0)
	{
		write(1, &c, 1);
		c = 0;
		i = 7;
		kill(clientpid, SIGUSR2);
	}
}

int	main(void)
{
	struct sigaction	act;

	act.sa_sigaction = &action_handler;
	act.sa_flags = SA_SIGINFO;
	ft_printf("Server PID : %d\n", getpid());
	sigaction(SIGUSR1, &act, NULL);
	sigaction(SIGUSR2, &act, NULL);
	while (1)
		pause();
	return (0);
}
