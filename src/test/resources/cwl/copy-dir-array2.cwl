cwlVersion: v1.0
class: Workflow

requirements:
    - class: ScatterFeatureRequirement

inputs:
  - id: inp_dirs
    type:
      type: array
      items: Directory
    inputBinding: {}
  - id: newnames
    type: string[]
    inputBinding: {}

steps:
    copydirs:
        in:
            inp: inp_dirs
            newname: newnames
        out:
            - out
        run: copy-dir.cwl 
        scatter: ["inp", "newname"]
        scatterMethod: dotproduct

outputs:
  - id: out
    type: Directory[]
    outputSource:
      copydirs/out