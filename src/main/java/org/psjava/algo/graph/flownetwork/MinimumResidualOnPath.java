package org.psjava.algo.graph.flownetwork;

import org.psjava.ds.graph.FlowNetworkEdge;
import org.psjava.ds.numbersystrem.AddableNumberSystem;
import org.psjava.formula.MinInIterable;
import org.psjava.util.ConvertedIterable;
import org.psjava.util.Converter;

public class MinimumResidualOnPath {

    public static <V, F, CE, FE extends FlowNetworkEdge<V, F, CE>> F find(Iterable<FE> path, final AddableNumberSystem<F> ns) {
        return MinInIterable.min(ConvertedIterable.create(path, new Converter<FE, F>() {
            @Override
            public F convert(FE e) {
                return Residual.calc(e, ns);
            }
        }), ns);
    }

    private MinimumResidualOnPath() {
    }

}
