function main {

    $excludes = @("*.md", "*.ppt", "*.pptx", ".*", "_*", "*.pdf")
    $NozipDirectory = @("HW_Compressed")
    $directory = "HW_Compressed"
    

    if (!(Test-Path "./$directory")) {
        mkdir "./$directory"
    }

    $a = Get-ChildItem -Directory -Exclude $NozipDirectory | Sort-Object CreationTime
    for ($i = 0; $i -lt $a.Count; $i++) {
        # 平常的作業皆以教授出作業當天日期(YYYYMMDD)命名，以便跟期中期末區隔
        $no = $i + 1
        if ($a[$i].BaseName -as [int]) {
            if ($no -le 9) {
                Get-ChildItem $a[$i].BaseName -Exclude $excludes | Compress-Archive -Force -DestinationPath "./$directory/hw0$no.zip"
            }
            else {
                Get-ChildItem $a[$i].BaseName -Exclude $excludes | Compress-Archive -Force -DestinationPath "./$directory/hw$no.zip" 
            }
        }
        else {
            if ($no -le 9) {
                Get-ChildItem $a[$i].BaseName -Exclude $excludes | Compress-Archive -Force -DestinationPath "./$directory/$($a[$i].BaseName).zip"
            }
            else {
                Get-ChildItem $a[$i].BaseName -Exclude $excludes | Compress-Archive -Force -DestinationPath "./$directory/$($a[$i].BaseName).zip" 
            }
        }
        
    }

    Write-Host "完成！"
    Pause
}

main