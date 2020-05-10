package de.pfist.historicmusicnotationtraining;

import de.pfist.historicmusicnotationtraining.domains.DomainRandomResult;
import de.pfist.historicmusicnotationtraining.domains.DomainSpecificState;
import de.pfist.historicmusicnotationtraining.domains.MusicDomain;

/**
 *
 * @param <S>
 * @param <R>
 * 
 * @see MusicDomain
 */
public interface WorkerExtension<S extends DomainSpecificState, R extends DomainRandomResult> {
	public R doRandom(/* S */ DomainSpecificState domainSpecificState);

}
