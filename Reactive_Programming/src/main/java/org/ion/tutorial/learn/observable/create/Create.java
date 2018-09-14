package org.ion.tutorial.learn.observable.create;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class Create {
	public static void main(String[] args) {
		
		Observable<String> source1 = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                try {
                	emitter.onNext("Alpha");
    				emitter.onNext("Beta");
    				emitter.onNext("Gamma");
    				emitter.onNext("Delta");
    				// emitter.onNext(null);  //This will throw null pointer exception
    				emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        });
		source1.map(String::length).filter(i -> i >= 5).subscribe(s -> System.out.println("RECEIVED: " + s),
				Throwable::printStackTrace);
		
		Observable<String> source2 = Observable.create(emitter -> {
			try {
				emitter.onNext("Alpha");
				emitter.onNext("Beta");
				emitter.onNext("Gamma");
				emitter.onNext("Delta");
				// emitter.onNext(null);  //This will throw null pointer exception
				emitter.onComplete();
			} catch (Throwable e) {
				emitter.onError(e);
			}
		});
		source2.map(String::length).filter(i -> i >= 5).subscribe(s -> System.out.println("RECEIVED: " + s),
				Throwable::printStackTrace);
	}
}
