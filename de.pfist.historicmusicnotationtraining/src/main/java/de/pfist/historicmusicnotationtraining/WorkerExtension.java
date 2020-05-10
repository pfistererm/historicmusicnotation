package de.pfist.historicmusicnotationtraining;

import de.pfist.historicmusicnotationtraining.domains.DomainRandomResult;
import de.pfist.historicmusicnotationtraining.domains.DomainSpecificState;

public interface WorkerExtension<S extends DomainSpecificState, R extends DomainRandomResult> {
	public R doRandom(/* S */ DomainSpecificState domainSpecificState);

}
