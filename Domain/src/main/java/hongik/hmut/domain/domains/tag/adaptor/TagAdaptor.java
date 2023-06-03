package hongik.hmut.domain.domains.tag.adaptor;


import hongik.hmut.core.annotation.Adaptor;
import hongik.hmut.domain.domains.tag.repository.TagRepository;
import lombok.RequiredArgsConstructor;

@Adaptor
@RequiredArgsConstructor
public class TagAdaptor {

    private final TagRepository tagRepository;
}
