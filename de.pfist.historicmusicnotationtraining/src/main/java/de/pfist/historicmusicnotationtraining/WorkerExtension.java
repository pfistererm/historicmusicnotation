package de.pfist.historicmusicnotationtraining;

public interface WorkerExtension<S extends DomainSpecificState, R extends DomainRandomResult> {
	public R doRandom(/* S */ DomainSpecificState domainSpecificState);

}
