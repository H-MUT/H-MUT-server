package hongik.hmut.domain.domains.group.adaptor;


import hongik.hmut.core.annotation.Adaptor;
import hongik.hmut.domain.domains.group.repository.TagRepository;
import lombok.RequiredArgsConstructor;

@Adaptor
@RequiredArgsConstructor
public class TagAdaptor {

    private final TagRepository tagRepository;
}
